package com.googlecode.lanterna.terminal

import java.io.{InputStream, OutputStream}
import java.nio.charset.Charset

import com.googlecode.lanterna.terminal.ansi.ANSITerminal
import com.googlecode.lanterna.terminal.ansi.UnixLikeTerminal.CtrlCBehaviour
import com.sun.jna.Pointer
import com.sun.jna.platform.win32.{Kernel32, WinNT, Wincon}
import com.sun.jna.ptr.IntByReference

class WindowsTerminal(terminalInput: InputStream, terminalOutput: OutputStream, terminalCharset: Charset, ctrlCBehaviour: CtrlCBehaviour)
  extends ANSITerminal(terminalInput, terminalOutput, terminalCharset) {
  private val wincon = Kernel32.INSTANCE
  setTerminalMode(Wincon.STD_INPUT_HANDLE, 0x0200) //ENABLE_VIRTUAL_TERMINAL_INPUT

  //ENABLE_VIRTUAL_TERMINAL_PROCESSING | DISABLE_NEWLINE_AUTO_RETURN | ENABLE_PROCESSED_OUTPUT
  setTerminalMode(Wincon.STD_OUTPUT_HANDLE, 0x0001 | 0x0004 | 0x0008)

  def this() = this(System.in, System.out, Charset.defaultCharset(), CtrlCBehaviour.CTRL_C_KILLS_APPLICATION)

  private def setTerminalMode(handle: Int, flags: Int): Unit = {
    val stdHandle: WinNT.HANDLE = wincon.GetStdHandle(handle)
    if (stdHandle.getPointer == Pointer.NULL) {
      throw new IllegalStateException("Unable to get console handle (no console window?)")
    }
    val mode = new IntByReference(0)
    wincon.GetConsoleMode(stdHandle, mode)
    mode.setValue(mode.getValue | flags)
    val success = wincon.SetConsoleMode(stdHandle, mode.getValue)
    if (!success) {
      val errCode = wincon.GetLastError().toHexString
      throw new RuntimeException(s"WinAPI call error: 0x$errCode")
    }
  }
}
