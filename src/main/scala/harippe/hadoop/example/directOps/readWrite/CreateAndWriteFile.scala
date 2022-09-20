package harippe.hadoop.example.directOps.readWrite

import harippe.hadoop.example.directOps.Connection
import org.apache.hadoop.fs.Path

object CreateAndWriteFile {

  def main(args: Array[String]): Unit = {

    val connection = new Connection("localhost", 9000)
    val path       = new Path("/user/harippe/test.txt")
    val input      = connection.connection.create(path)
    val content =
      s"""
         |Halo
         |Ini 
         |file 
         |baru
         |""".stripMargin
    input.write(content.getBytes)
    input.close()
  }

}
