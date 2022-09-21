package io.github.kijuky.line.notify

import io.github.kijuky.line.notify.prefs._
import io.github.kijuky.line.notify.prefs.key._

final case class Config(
  command: Command,
  message: Option[String],
  accessToken: Option[String]
)

object Config {
  def apply(): Config = {
    preferences(getClass) { prefs =>
      apply(
        command = Notify,
        message = None,
        accessToken = prefs.get(AccessToken)
      )
    }
  }
}

sealed trait Command
case object Notify extends Command
