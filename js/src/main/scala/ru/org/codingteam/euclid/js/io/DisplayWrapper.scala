package ru.org.codingteam.euclid.js.io

import ru.org.codingteam.euclid.io.{Display, TextBlockSize, TextMeasurementService}
import ru.org.codingteam.rotjs.ROT

class DisplayWrapper(display: ROT.Display) extends Display {
  override val textMeasurement: TextMeasurementService =
    (text: String, width: Int) => {
      val block = ROT.Text.measure(text, width)
      new TextBlockSize(block.width, block.height)
    }

  override def draw(x: Int, y: Int, ch: String, fg: String, bg: String): Unit = display.draw(x, y, ch, fg, bg)
  override def draw(x: Int, y: Int, ch: Array[String], fg: String, bg: String): Unit = display.draw(x, y, ch, fg, bg)
  override def drawText(x: Int, y: Int, text: String, maxWidth: Int): Int = display.drawText(x, y, text, maxWidth)

  override def width: Int = display.getOptions().width
  override def height: Int = display.getOptions().height

  /**
    * Clears the display.
    */
  override def clear(): Unit = display.clear()
}
