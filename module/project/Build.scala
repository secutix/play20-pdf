import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "pdf"
    val appVersion      = "0.5"

    val appDependencies = Seq(
      "org.xhtmlrenderer" % "flying-saucer-pdf-itext5" % "9.0.2",
      "com.itextpdf" % "itextpdf" % "5.4.2",
      "net.sf.jtidy" % "jtidy" % "r938"
	)

    val main =play.Project(appName, appVersion, appDependencies).settings(
      // hack to suppress javadoc error, see: https://play.lighthouseapp.com/projects/82401/tickets/898-javadoc-error-invalid-flag-g-when-publishing-new-module-local#ticket-898-7
      publishArtifact in(Compile, packageDoc) := false
    )

}
