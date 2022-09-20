package harippe.hadoop.example.directOps.readWrite

import java.io.{BufferedReader, InputStreamReader}

import id.nolimit.hadoop.example.directOps.Connection
import org.apache.hadoop.fs.{FSDataInputStream, Path}

object CreateWriteAndReadFile {

  def main(args: Array[String]): Unit = {

    val connection = new Connection("localhost", 9000)
    val path       = new Path("/user/harippe/test_rw.txt")
    val input      = connection.connection.create(path)
    println("Preparing file..")
    val content =
      s"""
         |Halo
         |Ini 
         |file 
         |baru
         |""".stripMargin
    println(content)
    input.write(content.getBytes)
    input.close()
    println("Finish writing to file!")
    println("Begin reading from file..")
    val output: FSDataInputStream = connection.connection.open(path)
    val reader                    = new BufferedReader(new InputStreamReader(output))
    var byteRead                  = 0
    val buffer                    = new StringBuffer()
    do {
      val array = new Array[Char](512)
      byteRead = reader.read(array)
      buffer.append(array)
    } while (byteRead >= 0)
    output.close()
    val str = buffer.toString
    println("Finish reading from file!")
    println(str)

  }

}
