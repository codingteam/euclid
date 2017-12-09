package ru.org.codingteam.euclid.io

trait Display {

  val textMeasurement: TextMeasurementService

  def draw(x: Int, y: Int, ch: String, fg: String = null, bg: String = null): Unit

  def draw(x: Int, y: Int, ch: Array[String], fg: String, bg: String): Unit

  def drawText(x: Int, y: Int, text: String, maxWidth: Int = 0): Int

  def width: Int

  def height: Int

  def drawTextCentered(x: Int, y: Int, width: Int, height: Int, text: String, topPadding: Option[Int]): Unit = {
    val measurement = textMeasurement.measure(text, width)

    val realX = x + (width - measurement.width) / 2
    val realY = y + topPadding.getOrElse((height - measurement.height) / 2)

    drawText(realX, realY, text)
  }

  def drawTextCentered(text: String, y: Option[Int] = None): Unit = drawTextCentered(0, 0, width, height, text, y)

  /**
    * Clears the display.
    */
  def clear()
}
