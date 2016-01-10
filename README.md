Eir
===

In Norse mythology, Eir is associated with healing.

The intention is to build a resilient, distributed applicaiton using Akka Persistence and Akka Clustering.

This initial implementation develops a simple CQRS system with journaling and snapshotting so that Actor state can
be easily tracked and recreated as needed when a system crashes.

Getting Started
====
This project doesn't have any external dependencies.  Getting started is simple:

1. Run the ```Start.scala``` app from IntelliJ or use ```sbt run``` from the command line.
2. The application will fire up and a couple of commands will be fired at the running system with output being logged
   to the console.
   
Supporting Sources
===

Bits of this implementation have been borrowed from the following interesting sources:

Resilient Applications with Akka Persistence - https://www.youtube.com/watch?v=qqNsGomfabc
Akka Persistence reference documentation - http://doc.akka.io/docs/akka/2.4.1/scala/persistence.html
