package com.imooc.scala.course08

import java.io.File
//import ImplicitAspect._
/**
  * Created by guiyonghui on 2018/9/25.
  */
object ImplicitApp extends App{

  //定义隐式转换函数即可

//  val man = new Man("PK")
//  man.fly()
//
//  val file = new File("/Users/guiyonghui/Documents/scala/scala-train/txt/hello.txt")
//  val txt = file.read
//  println(txt)

  def testParam(implicit name:String): Unit ={
    println(name + " =========== ")
  }

//  testParam("zhangsan")
//  implicit val name = "implicit_name"
//  testParam

//  implicit val s1 = "s1"
//  implicit val s2 = "s2"
//  testParam
}

class Man(val name:String) {

  def eat(): Unit ={
    println(s"man[ $name ] eat ....")
  }
}

class Superman(val name:String) {
  def fly(): Unit ={
    println(s"superman[ $name ] fly .....")
  }
}

class RichFile(val file:File) {
  def read()={
    scala.io.Source.fromFile(file.getPath).mkString
  }
}
