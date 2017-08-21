package com.imooc.log

import java.sql.{Connection, PreparedStatement}

import scala.collection.mutable.ListBuffer

/**
  * 各维度统计的DAO操作
  */
object StatDAO {

  /**
    * 批量保存DayVideoAccessStat数据到数据库
    * @param list
    */
  def insertDayVideoAccessTopN(list:ListBuffer[DayVideoAccessStat]):Unit = {

    var connection: Connection = null
    var pstmt: PreparedStatement = null
    try {
      connection = MySQLUtils.getConnection()

      connection.setAutoCommit(false)

      val sql = "insert into day_video_access_topn_stat(day,cms_id,times) values (?,?,?)"

      pstmt = connection.prepareStatement(sql)

      for (ele <- list) {
        pstmt.setString(1, ele.day)
        pstmt.setLong(2, ele.cmsId)
        pstmt.setLong(3, ele.times)

        pstmt.addBatch()
      }

      pstmt.executeBatch()
      connection.commit()
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      MySQLUtils.release(connection, pstmt)
    }
  }
}
