package com.imooc.scala.course05

/**
  * Created by guiyonghui on 2018/9/24.
  */
object ListApp extends App{

  val l = List(1, 2, 3, 4, 5)

  val l5 = scala.collection.mutable.ListBuffer[Int]()

  l5 += 2
  l5 += (3, 4, 5)
  l5 ++= List(6, 7, 8, 9)

  l5 -= 2
  l5 -= 3


  println(l5)


  def sum(nums:Int*): Int = {
    if (nums.length == 0) {
      0
    } else {
      nums.head + sum(nums.tail:_*)
    }
  }

  println(sum())
  println(sum(1, 2, 3, 4))

  val set = scala.collection.mutable.Set[Int]()
  set += 1
  set += 2
  set += 3
  set += 2

  println(set)

}
