addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.6.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "1.3.1")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.7.0")

addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.9.3")

addSbtPlugin("com.eed3si9n" % "sbt-unidoc" % "0.4.1")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "0.6.1")

// Required for building firrtl from source
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
addSbtPlugin("com.simplytyped" % "sbt-antlr4" % "0.8.2")
addSbtPlugin("com.github.gseitz" % "sbt-protobuf" % "0.6.5")
libraryDependencies += "com.github.os72" % "protoc-jar" % "3.11.4"
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.15")
