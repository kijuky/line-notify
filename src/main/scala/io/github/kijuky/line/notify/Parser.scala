package io.github.kijuky.line.notify

import scopt.OParser

object Parser {
  def parse(args: Array[String], config: Config): Option[Config] = {
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

    OParser.parse(parser, args, config)
  }
}
