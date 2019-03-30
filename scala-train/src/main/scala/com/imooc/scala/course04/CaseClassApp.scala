package com.imooc.scala.course04

/**
  * Created by guiyonghui on 2018/9/23.
  */
//通常用在模式匹配
object CaseClassApp {
  def main(args: Array[String]): Unit = {
    println(Dog("wangcai").name)
  }
}

//不需要new，直接使用即可
case class Dog(name:String)