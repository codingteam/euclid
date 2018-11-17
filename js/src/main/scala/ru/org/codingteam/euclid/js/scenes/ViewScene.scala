package ru.org.codingteam.euclid.js.scenes

import ru.org.codingteam.euclid.View
import ru.org.codingteam.euclid.io.{Display, KeyboardEvent}
import ru.org.codingteam.euclid.js.application.EuclidJsApp
import ru.org.codingteam.euclid.shape.Rectangle
import ru.org.codingteam.euclid.util.Logging
import ru.org.codingteam.euclid.viewmodels.{MenuViewModel, StaticTextViewModel, TextViewModel}
import ru.org.codingteam.euclid.views.{MenuView, TextView}
import ru.org.codingteam.rotjs.ROT

abstract class ViewScene(display: Display[_]) extends Scene(display) with Logging {

  def components: Vector[View[Int]]

  protected def renderOnKeyDown: Boolean = EuclidJsApp.currentScene.contains(this)

  override def render(): Unit = {
    log.debug("render")
    display.clear()
    components.foreach(_.render(display))
  }

  override def onKeyDown(event: KeyboardEvent[Int]): Unit = {
    components.foreach(_.onKeyDown(event))
    if (renderOnKeyDown) {
      render()
    }
  }

  protected def textView(shape: Rectangle, model: TextViewModel) = new TextView[Int](shape, model)
  protected def textView(model: TextViewModel): TextView[Int] =
    textView(Rectangle(0, 0, display.width, display.height), model)
  protected def textView(text: String): TextView[Int] = textView(new StaticTextViewModel(text))
  protected def menu(model: MenuViewModel): MenuView[Int] = new MenuView[Int](model) {
    override val keyMap = Map(
      ROT.VK_UP -> viewModel.up _,
      ROT.VK_DOWN -> viewModel.down _,
      ROT.VK_RETURN -> viewModel.execute _
    )
  }
}
