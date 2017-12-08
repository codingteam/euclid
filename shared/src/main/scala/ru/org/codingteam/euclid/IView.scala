package ru.org.codingteam.euclid

import ru.org.codingteam.euclid.io.{Display, KeyboardEvent}

trait IView[TKeyCode] {

  def render(display: Display): Unit
  def onKeyDown(event: KeyboardEvent[TKeyCode]): Unit

}
