package id.nolimit.hadoop.example.directOps.metadata

import id.nolimit.hadoop.example.directOps.Connection
import org.apache.hadoop.fs.Path

object RenameFile {

  def main(args: Array[String]): Unit = {

    val connection = new Connection("localhost", 9000)
    val path       = new Path("/user/harippe/test_rename.txt")
    val out        = connection.connection.create(path, true)
    out.close()
    val targetPath = new Path("/user/harippe/test_rename_3.txt")
    val result     = connection.connection.rename(path, targetPath)
    println(s"Is rename successful ${result}")
    val parentPath = targetPath.getParent
    val list       = connection.connection.listStatus(parentPath).toList
    println(list.map(_.getPath))
  }

}
