package ru.org.codingteam.euclid.views

import ru.org.codingteam.euclid.SimpleKeyMapView
import ru.org.codingteam.euclid.io.Display
import ru.org.codingteam.euclid.shape.Rectangle
import ru.org.codingteam.euclid.viewmodels.ItemsViewModel

/**
 * A list of typed items.
 */
class ListView[KeyCode, T](shape: Rectangle,
                  model: ItemsViewModel[T],
                  override val keyMap: ListView.KeyMap[KeyCode]) extends SimpleKeyMapView[KeyCode] {

  /**
   * A pair of model item and its name.
   */
  protected type Item = (T, String)

  override def render(display: Display): Unit = {
    val margin = 1
    model.items.vector.zipWithIndex foreach { case (item, index) =>
      val y = shape.y + index
      if (index > shape.height) {
        return
      }

      renderItem(display, item, shape.x + margin, y, shape.width - 2 * margin)
    }
  }

  protected def renderItem(display: Display, item: Item, x: Int, y: Int, width: Int): Unit = {
    val (value, name) = item
    if (model.selectedItem.contains(value)) {
      display.draw(shape.x, y, ">")
    }

    display.drawText(x, y, name, width)
  }
}

object ListView {

  type KeyMap[KeyCode] = Map[KeyCode, () => Unit]

  def bracketKeyMap[KeyCode, T](model: ItemsViewModel[T]): KeyMap[KeyCode] = Map(
    // TODO[F]: Define these at the platform level.
    // ROT.VK_OPEN_BRACKET -> model.up _,
    // ROT.VK_CLOSE_BRACKET -> model.down _
  )

  def arrowKeyMap[KeyCode, T](model: ItemsViewModel[T]): KeyMap[KeyCode] = Map(
    // TODO[F]: Define these at the platform level.
    // ROT.VK_UP -> model.up _,
    // ROT.VK_DOWN -> model.down _
  )
}
