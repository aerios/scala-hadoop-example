package harippe.hadoop.example.directOps.readWrite

import harippe.hadoop.example.directOps.Connection
import org.apache.hadoop.fs.Path

object CreateAndDeleteFile {

  def main(args: Array[String]): Unit = {
    val connection = new Connection("localhost", 9000)
    val path       = new Path("/user/harippe/test_delete.txt")
    val out        = connection.connection.create(path)
    out.close()
    connection.connection.delete(path, false)
  }

}
