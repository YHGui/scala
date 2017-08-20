package com.imooc.log

import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * 使用Spark完成我们的数据清洗操作
  */
object SparkStatCleanJob {
  def main(args: Array[String]): Unit = {

    val path = args(0)
    val cleanPath = args(1)

    val spark = SparkSession.builder().appName("SparkStatCleanJob").master("local[2]").getOrCreate()

    val accessRDD = spark.sparkContext.textFile(path)

    //RDD -> DF
    val accessDF = spark.createDataFrame(accessRDD.map(x => AccessConvertUtil.parseLog(x)), AccessConvertUtil.struct)
    //accessRDD.take(10).foreach(println)

    //accessDF.printSchema()
    //accessDF.show(30, false)

    accessDF.coalesce(1).write.format("parquet").mode(SaveMode.Overwrite).partitionBy("day")
      .save(cleanPath)

    spark.stop()
  }
}
