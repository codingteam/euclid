package ru.org.codingteam.euclid

import ru.org.codingteam.euclid.io.KeyboardEvent

trait SimpleKeyMapView[KeyCode] extends KeyMapView[KeyCode, KeyCode] {

  def mapEvent(event: KeyboardEvent[KeyCode]) = event.keyCode

}
