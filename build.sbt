name := """first"""
organization := "eng"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test


//libraryDependencies += "org.reactivemongo" %% "reactivemongo-bson" % "0.20.12"
libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.20.13-play27"
)

play.sbt.routes.RoutesKeys.routesImport += "play.modules.reactivemongo.PathBindables._"