organization := "org.xmlsmartdoc"

name := "SmartDoc"

version := "2.0-SNAPSHOT"

scalaVersion := "2.9.1"

scalacOptions += "-deprecation"

scalacOptions += "-unchecked"

resolvers += "Asami Maven Repository" at "http://www.asamioffice.com/maven"

libraryDependencies += "oro" % "oro" % "2.0.8"

libraryDependencies += "commons-beanutils" % "commons-beanutils" % "20030211.134440"

libraryDependencies += "org.apache.poi" % "poi" % "3.8-beta5"

libraryDependencies += "net.sourceforge.nekohtml" % "nekohtml" % "1.9.15"

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"

libraryDependencies += "org.apache.ant" % "ant" % "1.8.2" % "provided"

libraryDependencies += "junit" % "junit" % "4.8" % "test"

//

libraryDependencies += "relaxerorg" % "relaxerorg" % "1.0"

libraryDependencies += "isorelax" % "isorelax" % "1.0"

libraryDependencies += "tex2mathml" % "tex2mathml" % "1.0"
