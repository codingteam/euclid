package ru.org.codingteam.euclid.js.application

import ru.org.codingteam.euclid.js.io.DisplayWrapper
import ru.org.codingteam.euclid.js.scenes.ViewScene
import ru.org.codingteam.rotjs.ROT.Display

class MainMenuScene(display: Display) extends ViewScene(new DisplayWrapper(display)) {

  override val components = Vector(menu(new MainMenuViewModel(this)))

}
