import sbt._
class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val ideaRepo = "GH-pages repo" at "http://mpeltonen.github.com/maven/"

  val idea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.1-SNAPSHOT"
  val proguard = "org.scala-tools.sbt" % "sbt-proguard-plugin" % "0.0.4"
}

