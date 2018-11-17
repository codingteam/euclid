package ru.org.codingteam.euclid.js.io

import ru.org.codingteam.euclid.io.ColorFactory
import ru.org.codingteam.euclid.io._
import ru.org.codingteam.rotjs.ROT

class RotJsDisplay(display: ROT.Display) extends Display[String] {
  override val textMeasurement: TextMeasurementService =
    (text: String, width: Int) => {
      val block = ROT.Text.measure(text, width)
      new TextBlockSize(block.width, block.height)
    }

  override val colorFactory: ColorFactory[String] = RotJsColorFactory

  override def draw(x: Int, y: Int, ch: String, fg: Color[String], bg: Color[String]): Unit = {
    val fgImpl = Option(fg).map(_.impl).orNull
    val bgImpl = Option(bg).map(_.impl).orNull
    display.draw(x, y, ch, fgImpl, bgImpl)
  }

  override def draw(x: Int, y: Int, ch: Array[String], fg: Color[String], bg: Color[String]): Unit = {
    val fgImpl = Option(fg).map(_.impl).orNull
    val bgImpl = Option(bg).map(_.impl).orNull
    display.draw(x, y, ch, fgImpl, bgImpl)
  }

  override def drawText(x: Int, y: Int, text: String, maxWidth: Int): Int = display.drawText(x, y, text, maxWidth)

  override def width: Int = display.getOptions().width
  override def height: Int = display.getOptions().height

  /**
    * Clears the display.
    */
  override def clear(): Unit = display.clear()
}
