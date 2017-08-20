package com.imooc.log

import org.apache.spark.sql.SparkSession

/**
  * 使用Spark完成我们的数据清洗操作
  */
object SparkStatCleanJob {
  def main(args: Array[String]): Unit = {

    val path = args(0)

    val spark = SparkSession.builder().appName("SparkStatCleanJob").master("local[2]").getOrCreate()

    val accessRDD = spark.sparkContext.textFile(path)

    //RDD -> DF
    val accessDF = spark.createDataFrame(accessRDD.map(x => AccessConvertUtil.parseLog(x)), AccessConvertUtil.struct)
    //accessRDD.take(10).foreach(println)

    accessDF.printSchema()
    accessDF.show(30, false)

    spark.stop()
  }
}
