name := "advent-of-code-2021"

version := "0.1"

scalaVersion := "2.13.7"

scalacOptions in Compile += "-deprecation"

libraryDependencies ++= Seq(
  "com.github.tototoshi" %% "scala-csv" % "1.3.6",
  "org.typelevel" %% "cats-core" % "2.0.0",
  "org.scalameta" %% "scalafmt-core" % "2.2.0",
  "org.scalatest" %% "scalatest" % "3.0.8" % "it,test"
)
