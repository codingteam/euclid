package ru.org.codingteam.euclid.io

trait TextMeasurementService {
  def measure(text: String, width: Int): TextBlockSize
}
