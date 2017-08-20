package com.imooc.log

import org.apache.spark.sql.SparkSession

/**
  * 第一步清洗，抽取出我们所需要的指定列的数据
  */
object SparkStatFormatJob {
  def main(args: Array[String]): Unit = {
    val path = args(0)

    val spark = SparkSession.builder().appName("SparkStatFormatJob").master("local[2]").getOrCreate()

    val df = spark.sparkContext.textFile(path)

    spark.stop()
  }
}
