package ru.org.codingteam.euclid.js.application

import ru.org.codingteam.euclid.js.scenes.Scene
import ru.org.codingteam.euclid.viewmodels.MenuViewModel

class MainMenuViewModel(scene: Scene) extends MenuViewModel {
  override val header = "Euclid Test Application"

  override val items = Vector(
    "New Game" -> showText(1) _,
    "Load Game" -> showText(2) _
  )

  private def showText(x: Int)(): Unit = EuclidJsApp.setScene(new TextScene(scene.display, scene, s"Test text $x."))
}
