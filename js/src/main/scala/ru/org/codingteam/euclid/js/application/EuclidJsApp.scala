package ru.org.codingteam.euclid.js.application

import org.scalajs.dom.document
import ru.org.codingteam.euclid.js.scenes.Scene
import ru.org.codingteam.rotjs.DisplayOptions
import ru.org.codingteam.rotjs.ROT.Display

import scala.scalajs.js
import scala.scalajs.js.JSApp

object EuclidJsApp extends JSApp {

  val display: Display = new Display(js.Dynamic.literal(fontSize = 20).asInstanceOf[DisplayOptions])
  var currentScene: Option[Scene] = None

  def main(): Unit = {
    document.body.appendChild(display.getContainer())
    setScene(new MainMenuScene(display))
  }

  def setScene(scene: Scene): Unit = {
    currentScene match {
      case Some(s) => s.disable()
      case None =>
    }

    scene.enable()
    currentScene = Some(scene)
  }
}
