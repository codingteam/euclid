package ru.org.codingteam.euclid

import ru.org.codingteam.euclid.io.KeyboardEvent

trait KeyMapView[KeyCode, Event] extends View[KeyCode] {

  def keyMap: Map[Event, () => Unit]
  def mapEvent(event: KeyboardEvent[KeyCode]): Event

  override def onKeyDown(event: KeyboardEvent[KeyCode]): Unit = {
    val key = mapEvent(event)
    val action = keyMap.get(key)
    action map(_())
  }

}
