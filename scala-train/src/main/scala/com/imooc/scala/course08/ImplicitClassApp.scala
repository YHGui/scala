package com.imooc.scala.course08

/**
  * Created by guiyonghui on 2018/9/25.
  */
object ImplicitClassApp extends App{

  implicit class Calculator(x:Int){
    def add(a:Int) = a + x
  }

  println(1.add(3))

}


