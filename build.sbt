lazy val root = (project in file("."))
  .settings(
    name := "line-notify",
    scalaVersion := "2.13.10",
    scalacOptions ++= Seq("-Werror", "-Xlint"),
    libraryDependencies ++= Seq(
      "com.github.scopt" %% "scopt" % "4.1.0",
      "com.softwaremill.sttp.client3" %% "core" % "3.8.14"
    )
  )
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version),
    buildInfoPackage := "io.github.kijuky.line.notify"
  )
  .enablePlugins(NativeImagePlugin)
  .settings(
    nativeImageVersion := "21.3.0",
    nativeImageOptions ++= Seq("--enable-https", "-H:+AllowIncompleteClasspath")
  )
