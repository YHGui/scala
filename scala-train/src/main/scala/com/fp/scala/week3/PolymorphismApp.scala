package com.fp.scala.week3

object PolymorphismApp {

  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

  def main(args: Array[String]): Unit = {
    println(singleton[Int](1))
    println(singleton[Boolean](true))
  }

}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true

  override def head: T = throw new NoSuchElementException("Nil.head")

  override def tail: List[T] = throw new NoSuchElementException("Nil.tail")
}
