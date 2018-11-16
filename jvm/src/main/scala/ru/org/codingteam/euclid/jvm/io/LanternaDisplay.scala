package ru.org.codingteam.euclid.jvm.io

import com.googlecode.lanterna.TerminalTextUtils
import com.googlecode.lanterna.terminal.Terminal
import ru.org.codingteam.euclid.io.{Display, TextBlockSize, TextMeasurementService}

class LanternaDisplay(terminal: Terminal) extends Display {
  private val hardBreaks = Set('\n', '\f')
  private val softBreaks = Set(' ', '\t')

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
    terminal.flush()
  }

  override def draw(x: Int, y: Int, ch: Array[String], fg: String, bg: String): Unit = draw(x, y, Option(ch).orNull, fg, bg)

  override def drawText(x: Int, y: Int, text: String, maxWidth: Int): Int = {
    val tg = terminal.newTextGraphics()

    def findBreak(text: String, position: Int): Int = {
      val maxPos = Math.min(position, text.length - 1)
      var breakPos = maxPos
      for (i <- 0 to maxPos) {
        val c = text.charAt(i)
        if (hardBreaks.contains(c)) return i
        if (softBreaks.contains(c)) {
          breakPos = i
        }
      }
      breakPos
    }

    def drawLine(x: Int, y: Int, text: String, lineNumber: Int): Int = {
      val breakPos = findBreak(text, maxWidth)
      val (line, rest) = if (breakPos == text.length - 1) {
        (text, "")
      } else {
        (text.substring(0, breakPos), text.substring(breakPos).trim)
      }
      tg.putString(x, y, line)
      if (rest.isEmpty) {
        lineNumber
      } else {
        drawLine(x, y + 1, rest, lineNumber + 1)
      }
    }

    val lines = drawLine(x, y, text, 1)
    terminal.flush()
    lines
  }

  override def width: Int = terminal.getTerminalSize.getColumns

  override def height: Int = terminal.getTerminalSize.getRows

  /**
    * Clears the display.
    */
  override def clear(): Unit = terminal.clearScreen()
}
