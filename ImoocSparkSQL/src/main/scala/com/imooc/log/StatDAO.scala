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

  /**
    * 批量保存DayCityVideoAccessStat数据到数据库
    * @param list
    */
  def insertDayCityVideoAccessTopN(list:ListBuffer[DayCityVideoAccessStat]):Unit = {

    var connection: Connection = null
    var pstmt: PreparedStatement = null
    try {
      connection = MySQLUtils.getConnection()

      //手动提交
      connection.setAutoCommit(false)

      val sql = "insert into day_video_city_access_topn_stat(day,cms_id,city,times,times_rank) values (?,?,?,?,?)"

      pstmt = connection.prepareStatement(sql)

      for (ele <- list) {
        pstmt.setString(1, ele.day)
        pstmt.setLong(2, ele.cmsId)
        pstmt.setString(3, ele.city)
        pstmt.setLong(4, ele.times)
        pstmt.setInt(5, ele.timesRank)

        //将一组参数添加到prepareStatement对象内部
        pstmt.addBatch()
      }

      //将一批参数提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组
      pstmt.executeBatch()
      //手动提交
      connection.commit()
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      MySQLUtils.release(connection, pstmt)
    }
  }

  /**
    * 批量保存DayVideoTrafficsStat数据到数据库
    * @param list
    */
  def insertDayVideoTrafficsAccessTopN(list:ListBuffer[DayVideoTrafficsStat]):Unit = {

    var connection: Connection = null
    var pstmt: PreparedStatement = null
    try {
      connection = MySQLUtils.getConnection()

      connection.setAutoCommit(false)

      val sql = "insert into day_video_traffics_topn_stat(day,cms_id,traffics) values (?,?,?)"

      pstmt = connection.prepareStatement(sql)

      for (ele <- list) {
        pstmt.setString(1, ele.day)
        pstmt.setLong(2, ele.cmsId)
        pstmt.setLong(3, ele.traffics)

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

  def deleteData(day:String): Unit = {
    val tables = Array("day_video_access_topn_stat",
                       "day_video_city_access_topn_stat",
                       "day_video_traffics_topn_stat")

    var connection: Connection = null
    var pstmt:PreparedStatement = null

    try {

      connection = MySQLUtils.getConnection()
      for(table <- tables) {
        val deleteSQL = s"delete from $table where day = ?"
        pstmt = connection.prepareStatement(deleteSQL)
        pstmt.setString(1, day)
        pstmt.executeUpdate()
      }
    }catch{
      case e:Exception => e.printStackTrace()
    } finally {
      MySQLUtils.release(connection, pstmt)
    }





  }
}
