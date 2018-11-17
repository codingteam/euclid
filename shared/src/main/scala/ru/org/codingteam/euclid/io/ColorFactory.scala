package ru.org.codingteam.euclid.io

import ru.org.codingteam.euclid.io.AnsiColor.AnsiColor

trait ColorFactory[ImplType] {
  def ansi(color: AnsiColor):Color[ImplType]
}
