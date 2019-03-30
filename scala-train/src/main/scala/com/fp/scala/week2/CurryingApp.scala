package com.fp.scala.week2

/**
  * Created by guiyonghui on 2018/10/1.
  */
object CurryingApp {
  def main(args: Array[String]): Unit = {
    println(sumCubes(1, 10))
    println(sumFactorials(10, 20))

    println(sum(cube)(1, 10))
    println(sum(id)(1, 10))
    println(sum(fact)(1, 10))

    println(sumTailRecursion(id)(1, 10))
  }

  //functions returning functions
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    }
    sumF
  }

  def sumCurry(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumCurry(f)(a + 1, b)

  //sum function using linear recursion
  def sumTailRecursion(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)

  def sumInts = sum(x => x)

  def sumCubes = sum(x => x * x * x)

  def sumFactorials = sum(fact)

}
