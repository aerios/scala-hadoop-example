package id.nolimit.hadoop.example.directOps.readWrite

import id.nolimit.hadoop.example.directOps.Connection
import org.apache.hadoop.fs.{FSDataOutputStream, Path}

object CreateFile {

  def main(args: Array[String]): Unit = {

    val connection              = new Connection("localhost", 9000)
    val path                    = new Path("/user/harippe/test.txt")
    val out: FSDataOutputStream = connection.connection.create(path, true)
    out.close()
  }

}
