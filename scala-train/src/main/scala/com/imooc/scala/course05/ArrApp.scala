package com.imooc.scala.course05

/**
  * Created by guiyonghui on 2018/9/23.
  */
object ArrApp {

  def main(args: Array[String]): Unit = {

    val a = new Array[String](5)
    a.length
    a(1) = "hello"

    val b = Array("hadoop", "Spark")

    val d = scala.collection.mutable.ArrayBuffer[Int]()

    d += 1
    d += 2
    d += (3, 4, 5)
    d ++= Array(6, 7, 8)
    d.insert(0, 0)
    d.remove(0)
    d.remove(0, 3)
    d.trimEnd(2)
    d.toArray

//    for (ele <- d) {
//      println(ele)
//    }
//    for(i <- 0 until d.length) {
//      println(d(i))
//    }
    for(i <- (0 until d.length).reverse) {
      println(d(i))
    }
//    println(d)
//    println(d.toArray.mkString)
  }

}
