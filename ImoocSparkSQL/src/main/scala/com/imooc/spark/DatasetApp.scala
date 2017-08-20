package com.imooc.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by guiyonghui on 2017/8/20.
  */
object DatasetApp {

  def main(args: Array[String]): Unit = {
    val path = args(0)

    val spark = SparkSession.builder().appName("DatasetApp").master("local[2]").getOrCreate()

    //注意：需要导入隐式转换
    import spark.implicits._

    //spark如何解析csv文件
    val df = spark.read.option("header", "true").option("inferSchema", "true").csv(path)
    df.show()

    val ds = df.as[Sales]
    ds.map(line => line.itemId).show()

    spark.stop()
  }

  case class Sales(transactionId:Int,customerId:Int,itemId:Int,amountPaid:Double)

}
