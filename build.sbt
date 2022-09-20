name := "scala-hadoop-example"

version := "0.1"

scalaVersion := "2.12.6"

// https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-core
// https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-client
libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.10.1"
// https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-hdfs
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.10.1" % Test
// https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-mapreduce-client-core
libraryDependencies += "org.apache.hadoop" % "hadoop-mapreduce-client-core" % "2.10.1"
val meta = """META.INF(.)*""".r
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "services", "org.apache.hadoop.fs.FileSystem") => MergeStrategy.filterDistinctLines
  case meta(_)                                                             => MergeStrategy.discard
  case PathList("reference.conf")                                          => MergeStrategy.concat
  case _                                                                   => MergeStrategy.last
}

assemblyJarName in assembly := "main.jar"
