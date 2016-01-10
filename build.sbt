name := "Eir"

version := "1.0"

scalaVersion := "2.11.7"

val akka              = "2.4.1"


/* dependencies */
libraryDependencies ++= Seq (

  // -- Testing --
  "org.scalatest" %% "scalatest" % "2.2.2" % "test"

  // -- Logging --
  ,"ch.qos.logback" % "logback-classic" % "1.1.2"
  ,"com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

  // -- Akka --
  ,"com.typesafe.akka" %% "akka-testkit" % akka % "test"
  ,"com.typesafe.akka" %% "akka-actor" % akka
  ,"com.typesafe.akka" %% "akka-slf4j" % akka

  // --  Akka-Persistence --
  ,"com.typesafe.akka" %% "akka-persistence" % akka

  // -- Akka-Persistence Journal Dependencies --
  ,"org.iq80.leveldb"            % "leveldb"          % "0.7"
  ,"org.fusesource.leveldbjni"   % "leveldbjni-all"   % "1.8"


  // -- config --
  ,"com.typesafe" % "config" % "1.2.1"


)
    