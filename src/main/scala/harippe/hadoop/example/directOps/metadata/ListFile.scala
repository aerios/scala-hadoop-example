package harippe.hadoop.example.directOps.metadata

import harippe.hadoop.example.directOps.Connection
import org.apache.hadoop.fs.Path

object ListFile {

  def main(args: Array[String]): Unit = {

    val connection = new Connection("localhost", 9000)
    val path       = new Path("/user/harippe")
    val list       = connection.connection.listStatus(path).toList
    println(list)

  }

}
