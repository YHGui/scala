package com.imooc.spark

import org.apache.spark.sql.SparkSession

object DataFrameApp {

    def main(args: Array[String]) {

      val path = args(0)

      val spark = SparkSession.builder().appName("DataFrameApp").master("local[2]").getOrCreate()

      //将json文件加载成一个dataFrame
      val peopleDF = spark.read.format("json").load(path)

      //输出dataframe对应的schema信息
      peopleDF.printSchema()

      //展示，默认输出数据集的前二十条记录
      peopleDF.show()

      //查询某几列数据，并对列进行计算
      peopleDF.select(peopleDF.col("name"), (peopleDF.col("age") + 10).as("age2")).show()

      // 根据某一列的值进行过滤
      peopleDF.filter(peopleDF.col("age") > 20).show()

      // 根据某一列进行分组，然后在进行聚合操作：select age count(1) from table group by age
      peopleDF.groupBy("age").count().show()

      //查询某列的所有数据
      peopleDF.select("name").show()

      // 关闭资源
      spark.stop()
    }
}
