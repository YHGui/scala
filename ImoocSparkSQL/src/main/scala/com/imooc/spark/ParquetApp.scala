package com.imooc.spark

import org.apache.spark.sql.SparkSession

object ParquetApp {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SparkSessionApp").master("local[2]")getOrCreate()

    /**
      * spark.read.format("parquet").load(path)
      */
    val userDF = spark.read.format("parquet").load("file:///home/hadoop/app/spark-2.1.0-bin-2.6.0-cdh5.7.0/examples/src/main/resources/users.parquet")

    //默认是load parquet
    //spark.read.load("file:///home/hadoop/app/spark-2.1.0-bin-2.6.0-cdh5.7.0/examples/src/main/resources/users.parquet")

    spark.read.load()
    userDF.printSchema()
    userDF.show()
    userDF.select("name", "favorite_color").show()

    userDF.select("name", "favorite_color").write.format("json").save("file:///home/hadoop/tmp/jsonout2")

    spark.stop()
  }
}
