package io.github.kijuky.line.notify

package object prefs {
  def preferences[T](clazz: Class[_])(process: Preferences => T): T = {
    val prefs = Preferences.userNodeForPackage(clazz)
    process(prefs)
  }
}
