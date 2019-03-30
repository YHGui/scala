package com.imooc.scala.course09

import java.io.{FileInputStream, InputStreamReader}

import scala.xml.XML

/**
  * Created by guiyonghui on 2018/9/25.
  */
object XMLApp {

  def main(args: Array[String]): Unit = {

    readXMLAttr()
  }

  def readXMLAttr(): Unit = {

    val xml = XML.load(this.getClass.getClassLoader.getResource("test.xml"))

    val units = xml \\ "units"
    println(units)
  }


  def loadXML(): Unit ={
//    val xml = XML.load(this.getClass.getClassLoader.getResource("test.xml"))

//    val xml = XML.load(new FileInputStream("/Users/guiyonghui/Documents/scala/scala-train/src/main/resources/test.xml"))


    val xml = XML.load(new InputStreamReader(new FileInputStream("/Users/guiyonghui/Documents/scala/scala-train/src/main/resources/test.xml")))
    println(xml)

  }

}
