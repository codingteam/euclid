package ru.org.codingteam.euclid.views

import ru.org.codingteam.euclid.View
import ru.org.codingteam.euclid.io.{Display, KeyboardEvent}
import ru.org.codingteam.euclid.shape.Rectangle
import ru.org.codingteam.euclid.viewmodels.TextViewModel

class TextView[TKeyCode](shape: Rectangle, model: TextViewModel) extends View[TKeyCode] {

  override def render(display: Display[_]): Unit = {
    display.drawTextCentered(shape.x, shape.y, shape.width, shape.height, model.text, None)
  }

  override def onKeyDown(event: KeyboardEvent[TKeyCode]): Unit = ()
}
