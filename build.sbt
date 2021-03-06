/// Project

scalaVersion := "2.10.2"

name := "play-livescript"

sbtPlugin := true

version := "0.1"

organization := "com.github.otfoo"

description := "sbt plugin for handling LiveScript assets in Play"

/// Repositories

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

/// Dependencies

libraryDependencies ++= Seq(
)


addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.0")

/// Publish to local Play; specify this via sbt -Dplay.path=/your/play/path
publishTo := Some(playRepository)

publishMavenStyle := false
