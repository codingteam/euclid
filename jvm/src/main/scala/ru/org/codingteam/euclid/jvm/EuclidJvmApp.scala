package ru.org.codingteam.euclid.jvm

import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import ru.org.codingteam.euclid.io.Display
import ru.org.codingteam.euclid.jvm.io.LanternaDisplay

object EuclidJvmApp {
  val display: Display = new LanternaDisplay(new DefaultTerminalFactory().createTerminalEmulator())

  def main(args: Array[String]): Unit = {
    display.drawText(0, 0, "Hello JVM World")
  }
}
