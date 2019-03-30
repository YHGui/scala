package com.imooc.scala.course09

import java.sql.{Connection, DriverManager}

/**
  * Created by guiyonghui on 2018/9/25.
  */
object MysqlApp {

  def main(args: Array[String]): Unit = {
    val url = ""
    val username = ""
    val password = ""

    var connection:Connection = null

    try {

      //make the connection
      classOf[com.mysql.jdbc.Driver]


      //create the statement, and run the select query
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("select * from database limit 10")
      while (resultSet.next()) {
        val host = resultSet.getString("host")
        val user = resultSet.getString("user")

        println(s"$host, $user")
      }
    } catch {
      case e:Exception => println(e.getMessage)
    } finally {

      if(connection == null) {
        connection.close()
      }
    }
  }

}
