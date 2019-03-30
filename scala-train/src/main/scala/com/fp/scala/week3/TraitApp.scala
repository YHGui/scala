package com.fp.scala.week3

object TraitApp {

}

trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}
