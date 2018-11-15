package ru.org.codingteam.euclid.jvm.io

import com.googlecode.lanterna.TerminalTextUtils
import com.googlecode.lanterna.terminal.Terminal
import ru.org.codingteam.euclid.io.{Display, TextBlockSize, TextMeasurementService}

class LanternaDisplay(terminal: Terminal) extends Display {
  override val textMeasurement: TextMeasurementService = (text, width) => {
    val length = TerminalTextUtils.getColumnWidth(text)
    val w = Math.min(text.length, width)
    val h = if (width == 1) {
      length
    } else {
      length / width + 1
    }
    new TextBlockSize(w, h)
  }

  override def draw(x: Int, y: Int, ch: String, fg: String, bg: String): Unit = {
    //TODO implement ANSI colors
    Option(ch)
      .filter(!_.isEmpty)
      .map(_ (0))
      .foreach({
        terminal.setCursorPosition(x, y)
        terminal.putCharacter
      })
  }

  override def draw(x: Int, y: Int, ch: Array[String], fg: String, bg: String): Unit = draw(x, y, Option(ch).orNull, fg, bg)

  override def drawText(x: Int, y: Int, text: String, maxWidth: Int): Int = {
    //TODO handle multiline strings
    val tg = terminal.newTextGraphics()
    tg.putString(x, y, text)
    1
  }

  override def width: Int = terminal.getTerminalSize.getColumns

  override def height: Int = terminal.getTerminalSize.getRows

  /**
    * Clears the display.
    */
  override def clear(): Unit = terminal.clearScreen()
}
