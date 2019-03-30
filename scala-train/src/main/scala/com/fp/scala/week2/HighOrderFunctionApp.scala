package com.fp.scala.week2

/**
  * Created by guiyonghui on 2018/10/1.
  */
object HighOrderFunctionApp {
  def main(args: Array[String]): Unit = {
    println(sum(id, 3, 10))
    println(sum(cube, 3, 10))
    println(sum(fact, 3, 10))

    println(sum(x => x, 3, 10))
    println(sum(x => x * x * x, 3, 10))
  }

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }

  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)

}
