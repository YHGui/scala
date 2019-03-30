package com.imooc.spark

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}


object DataFrameRDDApp {
    def main(args: Array[String]): Unit = {

      val path = args(0)

      val spark = SparkSession.builder().appName("DataFrameRDDApp").master("local[2]").getOrCreate()

      //inferReflection(path, spark)
      program(path, spark)

      spark.stop()
    }

  private def program(path: String, spark: SparkSession) = {

    //RDD => DataFrame
    val rdd = spark.sparkContext.textFile(path)

    val infoRDD = rdd.map(_.split(",")).map(line => Row(line(0).toInt, line(1), line(2).toInt))

    val structType = StructType(Array(StructField("id", IntegerType, true),
      StructField("name", StringType, true),
      StructField("age", IntegerType, true)))

    val infoDF = spark.createDataFrame(infoRDD, structType)

    infoDF.printSchema()
    infoDF.show()

    infoDF.filter(infoDF.col("age") > 30).show()

    infoDF.createOrReplaceTempView("infos")
    spark.sql("select * from infos where age > 30").show()

  }

  private def inferReflection(path: String, spark: SparkSession) = {
    //RDD => DataFrame
    val rdd = spark.sparkContext.textFile(path)

    import spark.implicits._
    val infoDF = rdd.map(_.split(",")).map(line => Info(line(0).toInt, line(1), line(2).toInt)).toDF()

    infoDF.show()

    infoDF.filter(infoDF.col("age") > 30).show()

    infoDF.createOrReplaceTempView("infos")
    spark.sql("select * from infos where age > 30").show()
  }

  //java bean
  case class Info(id:Int, name: String, age:Int)
}
