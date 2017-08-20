package com.imooc.spark

import org.apache.spark.sql.SparkSession

object DataFrameCase {

  def main(args: Array[String]): Unit = {
    val path = args(0)

    val spark = SparkSession.builder().appName("DataFrameApp").master("local[2]").getOrCreate()

    //RDD => DataFrame
    val rdd = spark.sparkContext.textFile(path)

    import spark.implicits._
    val studentDF = rdd.map(_.split("\\|")).map(line => Student(line(0).toInt, line(1), line(2), line(3))).toDF()
    studentDF.show(30, false)

    studentDF.take(10).foreach(println)
    println(studentDF.first())
    studentDF.head(5)foreach(println)

    studentDF.select("email").head(30).foreach(println)
    studentDF.filter("name= '' OR name= 'NULL'").show()

    //name以M开头
    studentDF.filter("substring(name, 0, 1)='M'").show()

    studentDF.sort(studentDF("name").desc).show()
    studentDF.sort(studentDF("name").desc,studentDF("id").asc).show()
    studentDF.sort("name","id").show()

    val studentDF2 = rdd.map(_.split("\\|")).map(line => Student(line(0).toInt, line(1), line(2), line(3))).toDF()

    studentDF.join(studentDF2, studentDF.col("id") === studentDF2.col("id")).show()

    spark.stop()
  }

  case class Student(id: Int, name: String, phone: String, email: String)

}
