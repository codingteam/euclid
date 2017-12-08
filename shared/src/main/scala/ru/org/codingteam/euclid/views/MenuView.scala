package ru.org.codingteam.euclid.views

import ru.org.codingteam.euclid.SimpleKeyMapView
import ru.org.codingteam.euclid.io.Display
import ru.org.codingteam.euclid.util.Logging
import ru.org.codingteam.euclid.viewmodels.MenuViewModel

class MenuView[KeyCode](viewModel: MenuViewModel) extends SimpleKeyMapView[KeyCode] with Logging {

  val keyMap = Map(
    // TODO[F]: Define these at the platform level.
    //ROT.VK_UP -> viewModel.up _,
    //ROT.VK_DOWN -> viewModel.down _,
    //ROT.VK_RETURN -> viewModel.execute _
  )

  override def render(display: Display): Unit = {
    display.drawTextCentered("Keter", Some(1))
    display.drawTextCentered("=====", Some(2))

    val base = 4
    viewModel.items.zipWithIndex.foreach { case ((name, action), index) =>
      val (indent, text) = if (index == viewModel.selectedItem) {
        (2, s"> %b{#fff}%c{#000}$name%c{}%b{}")
      } else {
        (4, name)
      }

      display.drawText(indent, base + index, text)
    }
  }

}
