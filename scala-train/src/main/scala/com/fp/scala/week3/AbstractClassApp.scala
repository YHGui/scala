package com.fp.scala.week3

/**
  * Created by guiyonghui on 2018/10/3.
  * def variable call by name lazy evaluation
  */
object AbstractClassApp {
  def main(args: Array[String]): Unit = {
    println("hello, world")
  }
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet

}

class Empty extends IntSet {
  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def contains(x: Int): Boolean = false

  override def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  override def union(other: IntSet): IntSet = {
    /**
      * 直观版
      * val incl1 = other.incl(elem)
      * val incl2 = left.union(incl1)
      * right.union(incl2)
      */

    /**
      * 简洁版
      */
    ((left union right) union other) incl elem
  }

}

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo: Int = 2
  override def bar: Int = 3
}

object Empty extends IntSet {
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  override def union(other: IntSet): IntSet = other
}