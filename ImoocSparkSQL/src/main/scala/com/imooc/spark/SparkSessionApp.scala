package com.imooc.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{SQLContext, SparkSession}

object SparkSessionApp {
  def main(arg: Array[String]) {

    val path = arg(0)

    val spark = SparkSession.builder().appName("SparkSessionApp").master("local[2]")getOrCreate()

    val people = spark.read.json(path)
    people.show()

    //关闭资源
    spark.stop()
  }
}
