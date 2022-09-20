package id.nolimit.hadoop.example.directOps

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Hdfs}

class Connection(host: String, port: Int) {

  private val _conf = new Configuration()
  _conf.set("fs.defaultFS", s"hdfs://${host}:${port}/")
  private val _connection = FileSystem.get(_conf)
  def connection          = _connection
}
