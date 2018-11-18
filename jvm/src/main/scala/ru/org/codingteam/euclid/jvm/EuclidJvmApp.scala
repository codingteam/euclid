package ru.org.codingteam.euclid.jvm

import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import ru.org.codingteam.euclid.io.AnsiColor
import ru.org.codingteam.euclid.jvm.io.LanternaDisplay

object EuclidJvmApp {
  val display = new LanternaDisplay(new DefaultTerminalFactory().createTerminal())

  def main(args: Array[String]): Unit = {
    display.clear()
    display.drawText(0, 0, "Hello JVM World", 10)
    val colorFactory = display.colorFactory
    Thread.sleep(200)
    for (color <- AnsiColor.values) {
      display.clear()
      display.draw(0, 2, "@", Some(colorFactory.ansi(color)))
      display.drawText(0, 0, "Hello JVM World", 10)
      Thread.sleep(200)
    }
  }
}
