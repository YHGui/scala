package com.imooc.log

import org.apache.spark.sql.SparkSession

/**
  * 第一步清洗，抽取出我们所需要的指定列的数据
  */
object SparkStatFormatJob {
  def main(args: Array[String]): Unit = {
    val path = args(0)
    val savePath = args(1)

    val spark = SparkSession.builder().appName("SparkStatFormatJob").master("local[2]").getOrCreate()

    val access = spark.sparkContext.textFile(path)

    //access.take(10).foreach(println)

    /**
      * 原始日志的第三个和第四个字段拼接起来就是完整的时间
      * [10/Nov/2016:00:01:02 +0800] => yyyy-MM-dd HH:mm:ss
      */
    access.map(line => {
      val splits = line.split(" ")
      val ip = splits(0)
      val time = splits(3) + " " + splits(4)
      val url = splits(11).replaceAll("\"", "")
      val traffic = splits(9)

      //(ip, DateUtils.parse(time), url, traffic)

      DateUtils.parse(time) + "\t" + url + "\t" + traffic + "\t" + ip
    }).saveAsTextFile(savePath)


    spark.stop()
  }
}
