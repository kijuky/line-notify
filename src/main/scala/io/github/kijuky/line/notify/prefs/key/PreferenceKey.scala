package io.github.kijuky.line.notify.prefs.key

sealed abstract class PreferenceKey(val value: String)
case object AccessToken extends PreferenceKey("accessToken")
