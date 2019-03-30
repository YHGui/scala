package com.imooc.scala.course07

/**
  * Created by guiyonghui on 2018/9/24.
  */
object StringApp extends App{

  val greet = "hello "
  val name = "gui"
  println(greet + name)
  println(s"hello:$name")

  val team = "AC Milan"
  println(s"hello, $name, welcome to $team")

  val b =
    """
      |这是一个多行字符串
      |hello
      |world
      |PK
    """.stripMargin
  println(b)

}
