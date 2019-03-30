package com.imooc.scala.course04

/**
  * Created by guiyonghui on 2018/9/23.
  */
object ApplyApp {

  def main(args: Array[String]): Unit = {
    //    for(i <- 1 to 10) {
    //      ApplyTest.incr
    //    }
    //
    //    println(ApplyTest.count) //10 说明object本身就是一个单例对象
    val b = ApplyTest() //===> Object.apply 方法

    println("==============")
    val c = new ApplyTest()
    println(c)
    c()

    //类名() ===> Object.apply
    //对象() ===> Class.apply
  }
}

//伴生类和伴生对象：如果有一个class，且有一个与class同名的object，
// 那么称object为class的伴生对象，class为object的伴生类
class ApplyTest{

  def apply() = {
    println("Class ApplyTest apply....")

    new ApplyTest
  }

}

object ApplyTest{

  println("Object ApplyTest enter....")

  var count = 0

  def incr = {
    count = count + 1
  }

  //最佳实践：在Object的apply方法中去new Class
  def apply() = {
    println("Object ApplyTest apply....")

    new ApplyTest
  }

  println("Object ApplyTest leave....")
}




