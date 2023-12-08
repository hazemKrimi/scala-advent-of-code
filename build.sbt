ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "3.3.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala-advent-of-code",
    libraryDependencies += "org.scala-lang" %% "toolkit" % "0.2.0"
  )
