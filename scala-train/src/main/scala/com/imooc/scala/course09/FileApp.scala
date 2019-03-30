package com.imooc.scala.course09

import scala.io.Source

/**
  * Created by guiyonghui on 2018/9/25.
  */
object FileApp {

  def main(args: Array[String]): Unit = {

    val file = Source.fromFile("/Users/guiyonghui/Documents/scala/scala-train/txt/hello.txt", "utf-8")

    def readLine(): Unit = {
      for (line <- file.getLines()){
        println(line)
      }
    }

    def readChar(): Unit ={
      for (ele <- file) {
        println(ele)
      }
    }

    def readNetwork(): Unit ={
      val file = Source.fromURL("http://www.baidu.com")
      for(line <- file.getLines()) {
        println(line)
      }
    }

    //readLine()
//    readChar()
    readNetwork()
  }

}
