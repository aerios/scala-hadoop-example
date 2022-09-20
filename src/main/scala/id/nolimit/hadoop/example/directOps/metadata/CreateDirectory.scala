package id.nolimit.hadoop.example.directOps.metadata

import id.nolimit.hadoop.example.directOps.Connection
import org.apache.hadoop.fs.Path

object CreateDirectory {

  def main(args: Array[String]): Unit = {

    val connection = new Connection("localhost", 9000)
    val path       = new Path("/user/harippe/note")
    connection.connection.mkdirs(path)

  }

}
