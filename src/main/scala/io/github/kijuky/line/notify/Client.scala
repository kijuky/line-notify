package io.github.kijuky.line.notify

import sttp.client3._

case class Client(accessToken: String) {
  private val backend = HttpClientSyncBackend()
  val uri = uri"https://notify-api.line.me/api/notify"

  def notify(message: String): Response[Either[String, String]] = {
    val request = basicRequest
      .headers(Map("Authorization" -> s"Bearer $accessToken"))
      .body(Map("message" -> message))
      .post(uri)

    request.send(backend)
  }
}
