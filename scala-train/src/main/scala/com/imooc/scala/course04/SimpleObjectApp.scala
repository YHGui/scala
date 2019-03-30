package com.imooc.scala.course04

/**
  * Created by guiyonghui on 2018/9/23.
  */
object SimpleObjectApp {
  def main(args: Array[String]): Unit = {
    val person = new People()
    person.name = "Messi"
    println(person.name + ".." + person.age)

    println("invoke eat method " + person.eat)

    person.watchFootball("Barcelona")

    person.printInfo()


  }

}

class People{
  var name:String = _ //自动生成get和set方法
  val age:Int = 10 // 自动生成get方法，没有set方法

  //private [this]修饰的属性只能在class内部被访问
  private [this] val gender = "male"

  def printInfo(): Unit = {
    println("gender: " + gender)
  }

  def eat():String = {
    name + " eat..."
  }

  def watchFootball(teamName: String): Unit = {
    println(name + " is watching match of " + teamName)
  }
}
