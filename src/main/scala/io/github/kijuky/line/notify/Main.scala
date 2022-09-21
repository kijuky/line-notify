package io.github.kijuky.line.notify

import io.github.kijuky.line.notify.prefs._
import io.github.kijuky.line.notify.prefs.key._
import scopt.OParser

object Main extends App {
  val parser = {
    val builder = OParser.builder[Config]
    import builder._

    val argMessage = arg[String]("message")
      .text("notify message")
      .action((message, c) => c.copy(message = Some(message)))

    val optAccessToken = opt[String]("token")
      .text("personal access token")
      .action((accessToken, c) => c.copy(accessToken = Some(accessToken)))

    OParser.sequence(
      programName(BuildInfo.name),
      head(BuildInfo.name, BuildInfo.version),
      argMessage,
      optAccessToken,
      cmd("Notify")
        .text("notify")
        .action((_, c) => c.copy(command = Notify))
        .children(argMessage, optAccessToken)
    )
  }

  OParser.parse(parser, args, Config()) match {
    case Some(Config(Notify, Some(message), Some(accessToken))) =>
      notify(message, accessToken)
    case _ =>
      System.err.println("illegal arguments")
  }

  def notify(message: String, accessToken: String): Unit = {
    Client(accessToken).notify(message).body match {
      case Right(body) =>
        // アクセストークンをキャッシュする
        preferences(getClass) { prefs =>
          prefs.put(AccessToken, accessToken)
        }

        // 成功メッセージを出力
        println(body)

      case Left(error) =>
        System.err.println(error)
    }
  }
}
