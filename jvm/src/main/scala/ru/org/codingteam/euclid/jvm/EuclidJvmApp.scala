package ru.org.codingteam.euclid.jvm

import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import ru.org.codingteam.euclid.io.{AnsiColor, ColorFactory, Display}
import ru.org.codingteam.euclid.jvm.io.LanternaDisplay

object EuclidJvmApp {
  val display = new LanternaDisplay(new DefaultTerminalFactory().createTerminalEmulator())

  def main(args: Array[String]): Unit = {
    display.drawText(0, 0, "Hello JVM World", 10)
    val colorFactory = display.colorFactory
    Thread.sleep(200)
    for (color <- AnsiColor.values) {
      display.draw(0, 2, "@", colorFactory.ansi(color))
      display.drawText(0, 0, "Hello JVM World", 10)
      Thread.sleep(200)
    }
  }
}
