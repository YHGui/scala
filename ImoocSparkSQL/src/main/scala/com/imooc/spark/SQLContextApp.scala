package com.imooc.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}


object SQLContextApp {
  def main(arg: Array[String]) {

    val path = arg(0)

    val sparkConf = new SparkConf()

    //在测试或者生产中，AppName和Master我们是通过脚本进行指定
    //sparkConf.setAppName("SQLContextApp").setMaster("local[2]")

    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)

    val people = sqlContext.read.format("json").load(path)
    people.printSchema()
    people.show()


    sc.stop()
  }
}
