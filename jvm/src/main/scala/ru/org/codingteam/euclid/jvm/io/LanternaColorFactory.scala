package ru.org.codingteam.euclid.jvm.io

import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.TextColor.{ANSI, Indexed}
import ru.org.codingteam.euclid.io.AnsiColor.AnsiColor
import ru.org.codingteam.euclid.io.{AnsiColor, Color, ColorFactory}

object LanternaColorFactory extends ColorFactory[TextColor]{
  case class TerminalColor(impl:TextColor) extends Color[TextColor]

  override def ansi(color: AnsiColor): Color[TextColor] = color match {
    case AnsiColor.Black => TerminalColor(new Indexed(0))
    case AnsiColor.DarkRed => TerminalColor(new Indexed(1))
    case AnsiColor.DarkGreen => TerminalColor(new Indexed(2))
    case AnsiColor.DarkYellow => TerminalColor(new Indexed(3))
    case AnsiColor.DarkBlue => TerminalColor(new Indexed(4))
    case AnsiColor.DarkMagenta => TerminalColor(new Indexed(5))
    case AnsiColor.DarkCyan => TerminalColor(new Indexed(6))
    case AnsiColor.DarkGray => TerminalColor(new Indexed(8))
    case AnsiColor.LightGray => TerminalColor(new Indexed(7))
    case AnsiColor.Red => TerminalColor(new Indexed(9))
    case AnsiColor.Green => TerminalColor(new Indexed(10))
    case AnsiColor.Yellow => TerminalColor(new Indexed(11))
    case AnsiColor.Blue => TerminalColor(new Indexed(12))
    case AnsiColor.Magenta => TerminalColor(new Indexed(13))
    case AnsiColor.Cyan => TerminalColor(new Indexed(14))
    case AnsiColor.White => TerminalColor(new Indexed(15))
    case _ => throw new IllegalArgumentException("Unknown color: " + color)
  }
}
