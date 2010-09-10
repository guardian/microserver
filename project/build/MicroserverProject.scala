import sbt._

class MicroserverProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  val commonsIo = "commons-io" % "commons-io" % "1.4" withSources()

  val jetty = "org.mortbay.jetty" % "jetty" % "6.1.24"
  val jettyUtil = "org.mortbay.jetty" % "jetty-util" % "6.1.24"

  val servletApi = "javax.servlet" % "servlet-api" % "2.5" withSources()
}

