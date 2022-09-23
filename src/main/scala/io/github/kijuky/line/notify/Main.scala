package io.github.kijuky.line.notify

import io.github.kijuky.line.notify.prefs._
import io.github.kijuky.line.notify.prefs.key._

object Main extends App {
  Parser.parse(args, Config()) match {
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
