package com.imooc.log

import java.util.Date
import java.text.SimpleDateFormat
import java.util.Locale

import org.apache.commons.lang3.time.FastDateFormat


object DateUtils {

  /**
    * SimpleDateFormat线程不安全，换成FastDateFormat即可
    * 导致解析出错
    */
  //输入文件日期格式
  val YYYYMMDDHHMM_TIME_FORMAT = FastDateFormat.getInstance("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH)

  //目标日期格式
  val TARGET_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")

  /**
    * 获取时间：yyyy-MM-dd HH:mm:ss
    * @param time
    * @return
    */
  def parse(time:String) = {
    TARGET_FORMAT.format(new Date(getTime(time)))
  }
  /**
    * 获取输入日志时间：long类型
    * @param time
    * @return
    */
  def getTime(time:String) = {
    try {
      YYYYMMDDHHMM_TIME_FORMAT.parse(time.substring(time.indexOf("[") + 1,
        time.lastIndexOf("]"))).getTime
    } catch {
      case e: Exception => {
        0l
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(parse("[10/Nov/2016:00:01:02 +0800]"))
  }

}
