name := "spark"

version := "1.0"

scalaVersion := "2.11.3"


//add Library
libraryDependencies ++= Seq{
  "org.apache.spark" %% "spark-core" % "1.2.0" % "provided"
}