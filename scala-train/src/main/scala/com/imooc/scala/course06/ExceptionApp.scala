package com.imooc.scala.course06

/**
  * Created by guiyonghui on 2018/9/24.
  */
object ExceptionApp extends App{

  val test = "test.txt"

  try {
    //open file
    // use file

    val i = 10 / 0
    println(i)
  }catch {
    case e:ArithmeticException => println("除数不能为0")
    case e:Exception => println(e.getMessage)
  }finally {
    //释放资源，一定执行:close file
  }
}
