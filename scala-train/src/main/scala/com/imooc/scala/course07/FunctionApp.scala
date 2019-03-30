package com.imooc.scala.course07

/**
  * Created by guiyonghui on 2018/9/24.
  * 匿名函数：函数是可以命名的，也可以不命名
  * (参数名：参数类型) => 函数体
  */
object FunctionApp extends App{

  def sum(a:Int, b:Int) = a + b

  println(sum(2, 3))

  def sum2(a:Int)(b:Int) = a + b
  println(sum2(2)(3))

  val l = List(1, 2, 3, 4, 5, 6, 7, 8)
  //map:逐个操作集合中的每个元素
  println(l)
  val l2 = l.map((x:Int)=> x + 1)
  println(l2)
  val l3 = l.map((x) => x * 2)
  println(l3)
  val l4 = l.map(_ * 3)
  l.map(_ + 3).foreach(println)
  println(l4)

  l.map(_ * 2).filter(_ > 8).foreach(println)
  l.take(2).foreach(println)

  println(l.reduce(_ + _))//相邻相加
  println(l.reduce(_ - _))//相邻相减
  println(l.reduceLeft(_ - _))//
  println(l.reduceRight(_ - _))//
  println(l.fold(0)(_ - _))//

  val numbers = List(1,2,3,4,5,6,7,8,9,10)

  val f = List(List(1, 2), List(3, 4), List(5, 6))

  val txt = scala.io.Source.fromFile("/Users/guiyonghui/Documents/scala/scala-train/txt/hello.txt").mkString

//  println(txt)
  val txts = List(txt)
  val pairs = txts.flatMap(_.split(",")).map(x => (x, 1)).foreach(println)

  def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
    numbers.foldRight(List[Int]()) {
      (x : Int, xs: List[Int]) => fn(x) :: xs
    }
  }

  def timesTwo(i: Int): Int = i * 2

  ourMap(numbers, timesTwo(_)).foreach(println)
}
