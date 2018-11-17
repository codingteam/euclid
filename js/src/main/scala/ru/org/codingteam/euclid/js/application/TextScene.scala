package ru.org.codingteam.euclid.js.application

import ru.org.codingteam.euclid.View
import ru.org.codingteam.euclid.io.{Display, KeyboardEvent}
import ru.org.codingteam.euclid.js.scenes.{Scene, ViewScene}
import ru.org.codingteam.rotjs.ROT

class TextScene(display: Display[_], parentScene: Scene, text: String) extends ViewScene(display) {

  override def components: Vector[View[Int]] =
    Vector(textView(text))

  override def onKeyDown(event: KeyboardEvent[Int]): Unit = {
    event.keyCode match {
      case c if c == ROT.VK_RETURN => EuclidJsApp.setScene(parentScene)
      case _ =>
    }
  }
}
