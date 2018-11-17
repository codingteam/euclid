package ru.org.codingteam.euclid.js.io

import ru.org.codingteam.euclid.io.AnsiColor.AnsiColor
import ru.org.codingteam.euclid.io.{AnsiColor, Color, ColorFactory}

object RotJsColorFactory extends ColorFactory[String]{
  case class RotJsColor(impl:String) extends Color[String]

  override def ansi(color: AnsiColor): Color[String] = color match {
    case AnsiColor.Black => RotJsColor("#00000")
    case AnsiColor.DarkRed => RotJsColor("#AA0000")
    case AnsiColor.DarkGreen => RotJsColor("#00AA00")
    case AnsiColor.DarkYellow => RotJsColor("#55AA00")
    case AnsiColor.DarkBlue => RotJsColor("#0000AA")
    case AnsiColor.DarkMagenta => RotJsColor("#AA00AA")
    case AnsiColor.DarkCyan => RotJsColor("#00AAAA")
    case AnsiColor.DarkGray => RotJsColor("#555555")
    case AnsiColor.LightGray => RotJsColor("#AAAAAA")
    case AnsiColor.Red => RotJsColor("#FF5555")
    case AnsiColor.Green => RotJsColor("#55FF55")
    case AnsiColor.Yellow => RotJsColor("#FFFF55")
    case AnsiColor.Blue => RotJsColor("#5555FF")
    case AnsiColor.Magenta => RotJsColor("#FF55FF")
    case AnsiColor.Cyan => RotJsColor("#55FFFF")
    case AnsiColor.White => RotJsColor("#FFFFFF")
    case _ => throw new IllegalArgumentException("Unknown color: " + color)
  }
}
