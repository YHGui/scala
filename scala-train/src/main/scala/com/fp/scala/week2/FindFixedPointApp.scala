package com.fp.scala.week2

/**
  * Created by guiyonghui on 2018/10/1.
  */
object FindFixedPointApp {

  val tolerance = 0.0001
  def main(args: Array[String]): Unit = {
    println(sqrt(2.0))
  }

  def isCloseEnough(x: Double, y: Double) =
    ((x - y) / x).abs / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      println(next)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  def sqrt(x: Double) =
    fixedPoint(y => (y + x / y) / 2)(1.0)

  def sqrtAverageDamp(x: Double) = fixedPoint(averageDamp(y => x / y))(1.0)
}
