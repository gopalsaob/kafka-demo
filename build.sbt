name := "KafkaDemo"
scalaVersion := "2.11.8"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.10.0.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.0"

libraryDependencies += "net.manub" %% "scalatest-embedded-kafka" % "0.7.0" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.21" % "test"


