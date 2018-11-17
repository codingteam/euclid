package ru.org.codingteam.euclid

import ru.org.codingteam.euclid.io.{Display, KeyboardEvent}

trait View[TKeyCode] {
  def render(display: Display[_]): Unit
  def onKeyDown(event: KeyboardEvent[TKeyCode]): Unit
}
