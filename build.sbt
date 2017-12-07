name := "Euclid root"
scalaVersion in ThisBuild := "2.12.3"

lazy val root = project.in(file("."))
  .aggregate(euclidJS, euclidJVM)
  .settings(
    publish := {},
    publishLocal := {}
  )

lazy val euclid = crossProject.in(file("."))
  .settings(
    name := "euclid",
    version := "0.0.1-SNAPSHOT",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.4" % "test"
  )
  .jvmSettings()
  .jsSettings(
    scalaJSUseMainModuleInitializer := true
  )

lazy val euclidJVM = euclid.jvm
lazy val euclidJS = euclid.js
