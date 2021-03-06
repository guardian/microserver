import sbt._

class MicroserverProject(info: ProjectInfo) extends DefaultProject(info)
        with IdeaProject
        with ProguardProject {
  val commonsIo = "commons-io" % "commons-io" % "1.4" withSources()

  val jetty = "org.mortbay.jetty" % "jetty" % "6.1.24" intransitive()
  val jettyUtil = "org.mortbay.jetty" % "jetty-util" % "6.1.24" intransitive()

  val servletApi = "javax.servlet" % "servlet-api" % "2.5" withSources()


  lazy val dist = distAction dependsOn (proguard) describedAs "create distribution zip"
  def distAction = zipTask(distPaths, "dist", "microserver.zip" )

  def distPaths = "config.properties" +++ "LICENSE.txt" +++ ( (outputPath ##) / minJarName)


  override def proguardOptions = List(
    "-keep public class com.gu.microserver.MicroServer { public static void main(java.lang.String[]); }",
    "-keep class org.mortbay.**")
}

