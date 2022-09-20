# Simple Hadoop Example

## Description

This example of MapReduce job is direct port of [this tutorial](https://hadoop.apache.org/docs/stable/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html) written in Scala

## How to build

```sbt assembly```

The uberjar will be stored in `target/scala-2.12/main.jar`

## How to run as MR job

```
./bin/hadoop jar /path/to/main.jar harippe.hadoop.example.mapReduce.WordCount /hdfs/path/of/input/dir /hdfs/path/of/output
```
