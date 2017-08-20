package com.imooc.log

import scala.collection.mutable.ListBuffer

/**
  * 各维度统计的DAO操作
  */
object StatDAO {

  /**
    * 批量保存数据到数据库
    * @param list
    */
  def insertDayVideoAccessTopN(list:ListBuffer[DayVideoAccessStat]):Unit = {
    val connection = MySQLUtils.getConnection()

    connection.setAutoCommit(false)

    val sql = "insert into day_video_access_topn_stat(day,cms_id,times) values (?,?,?)"


  }
}
