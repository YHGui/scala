package com.imooc.scala.course03

/**
  * Created by guiyonghui on 2018/9/23.
  */
object FunctionApp {
  def main(args: Array[String]): Unit = {
//    println(add(2, 3))
//    println(three())
//    println(three) //没有入参的函数，调用时括号可以省略
//    sayHello
//    sayHello("katsura")
//    sayName()
//    println(speed(100, 2))
//    println(speed(time = 2, distance = 100))
//    println(sum2(1))
//    println(sum2(1,2))
//    println(sum2(1,2,3))
//    println(1 to 10)
//    println(Range(1, 10))
//    println(1 until 10)
    val courses = Array("Spark Streaming", "Hadoop", "Storm", "Spark Sql", "Scala")
    for (course <- courses) {
      println(course)
    }

    courses.foreach(course =>println(course))
    //course其实就是courses里面的每个元素，将左边的course作用上函数，然后得到一个结果

    var (num, sum) = (100, 0)
    while (num > 0 ){
      sum = sum + num
      num = num - 1
    }
    println(sum)
  }

  def add(x:Int, y:Int):Int = {
    x + y //最后一行就是返回值，无需return
  }

  def three() = {
    1 + 2
  }

  def sayHello(): Unit = {
    println("say hi")
  }

  def sayHello(name:String): Unit ={
    println("say hi to " + name)
  }

  def sayName(name:String = "PK"): Unit = {
    sayHello(name)
  }

  def speed(distance:Float, time:Float):Float = {
    distance / time
  }

  def sum(a:Int, b:Int):Int = {
    a + b
  }

  def sum2(numbers:Int*) = {
    var result = 0
    for (number <- numbers){
      result += number
    }

    result
  }

}
