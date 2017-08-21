package com.imooc.log

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

import scala.collection.mutable.ListBuffer
/**
  * TopN统计Spark作业
  */
object TopNStatJob {

  /**
    * 最受欢迎的TopN课程
    * @param spark
    * @param accessDF
    * @return
    */
  def videoAccessTopNStat(spark: SparkSession, accessDF: DataFrame) = {

    /**
      * 使用dataframe方式统计
      */
    //    import spark.implicits._
//
//    val videoAccessTopNDf = accessDF.filter($"day" === "20170511" && $"cmsType" === "video")
//      .groupBy("day", "cmsId").agg(count("cmsId").as("times")).orderBy($"times".desc)
//
//    videoAccessTopNDf.show()

    /**
      * 使用sql方式进行统计
      */
    accessDF.createOrReplaceTempView("access_logs")
    val videoAccessTopNDf = spark.sql("select day,cmsId,count(1) as times from access_logs " +
      "where day='20170511' and cmsType='video' " +
      "group by day,cmsId order by times desc")

    val articleAccessTopNDf = spark.sql("select day,cmsId,count(1) as times from access_logs " +
      "where day='20170511' and cmsType='article' " +
      "group by day,cmsId order by times desc")


    videoAccessTopNDf.show(false)

    articleAccessTopNDf.show(false)

    //将统计结果写入到mysql中
    try {
      videoAccessTopNDf.foreachPartition(partitionOfRecords => {
        val list = new ListBuffer[DayVideoAccessStat]

        partitionOfRecords.foreach(info => {
          val day = info.getAs[String]("day")
          val cmsId = info.getAs[Long]("cmsId")
          val times = info.getAs[Long]("times")

          list.append(DayVideoAccessStat(day, cmsId, times))
        })

        StatDAO.insertDayVideoAccessTopN(list)
      })
    } catch {
      case e:Exception => e.printStackTrace()
    }

  }

  def main(args: Array[String]): Unit = {
    val path = args(0)

    val spark = SparkSession.builder().appName("SparkStatCleanJob")
        .config("spark.sql.sources.partitionColumnTypeInference.enabled",false)
      .master("local[2]").getOrCreate()

    val accessDF = spark.read.format("parquet").load(path)
    accessDF.printSchema()
    accessDF.show(false)

    videoAccessTopNStat(spark, accessDF)

    spark.stop()
  }

}
