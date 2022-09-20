package id.nolimit.hadoop.example.mapReduce

import java.lang
import java.util.StringTokenizer

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.{IntWritable, Text}
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.mapreduce.{Mapper, Reducer}

object WordCount {

  object TokenizerMapper extends Mapper[Any, Text, Text, IntWritable] {

    override def map(key: scala.Any, value: Text, context: Mapper[Any, Text, Text, IntWritable]#Context): Unit = {

      val itr = new StringTokenizer(value.toString)
      while (itr.hasMoreTokens) {
        val text = new Text()
        text.set(itr.nextToken())
        context.write(text, new IntWritable(1))
      }
    }

  }

  object IntReducer extends Reducer[Text, IntWritable, Text, IntWritable] {
    override def reduce(
        key: Text,
        values: lang.Iterable[IntWritable],
        context: Reducer[Text, IntWritable, Text, IntWritable]#Context
    ): Unit = {
      var sum      = 0
      val iterator = values.iterator()
      while (iterator.hasNext) {
        sum += iterator.next().get()
      }
      context.write(key, new IntWritable(sum))
    }
  }

  def main(args: Array[String]): Unit = {
    import org.apache.hadoop.io.IntWritable
    import org.apache.hadoop.mapreduce.Job
    val conf = new Configuration()
    val job  = Job.getInstance(conf, "word count")
    job.setJarByClass(WordCount.getClass)
    job.setMapperClass(WordCount.TokenizerMapper.getClass)
    job.setCombinerClass(WordCount.IntReducer.getClass)
    job.setReducerClass(WordCount.IntReducer.getClass)
    job.setOutputKeyClass(classOf[Text])
    job.setOutputValueClass(classOf[IntWritable])
    FileInputFormat.addInputPath(job, new Path(args(0)))
    FileOutputFormat.setOutputPath(job, new Path(args(1)))
    System.exit(
      if (job.waitForCompletion(true)) 0
      else 1
    )

  }
}
