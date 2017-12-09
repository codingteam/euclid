package ru.org.codingteam.euclid.js.scenes

import org.scalajs.dom
import org.scalajs.dom.document
import ru.org.codingteam.euclid.io.{Display, KeyboardEvent}

abstract class Scene(val display: Display) {

  def keyDownListener(event: dom.KeyboardEvent): Unit = {
    onKeyDown(new KeyboardEvent[Int](event.keyCode))
  }
  
  def enable(): Unit = {
    document.onkeydown = keyDownListener
    render()
  }

  def disable(): Unit = {
    document.onkeydown = null
  }
  
  protected def onKeyDown(event: KeyboardEvent[Int]): Unit
  protected def render(): Unit
}
