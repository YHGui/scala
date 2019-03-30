package com.imooc.scala.course06

import scala.util.Random

/**
  * Created by guiyonghui on 2018/9/24.
  */
object MatchApp extends App{

//  val names = Array("gyh", "katsura", "gui")
//  val name = names(Random.nextInt(names.length))
//
//  name match {
//    case "gyh" => println("桂永辉")
//    case "katsura" => println("假面")
////    case "gui" => println("桂")
//    case _ => println("What are you talking about?")
//  }
//
//  def judgeGrade(grade:String): Unit = {
//    grade match {
//      case "A" => println("excellent")
//      case "B" => println("Good")
//      case "C" => println("Just so so")
//      case _ => println("good good study, day day up")
//    }
//  }
//
//  judgeGrade("A")
//  judgeGrade("D")


  def judgeGrade(name:String, grade:String): Unit = {
    grade match {
      case "A" => println("excellent")
      case "B" => println("Good")
      case "C" => println("Just so so")
      case _ if(name == "gui")=> println(name + ", good good study, day day up!")
      case _ => println("Work Harder")
    }
  }

  judgeGrade("zhangsan", "d")
  judgeGrade("gui", "d")


  def greeting(array:Array[String]): Unit = {
    array match {
      case Array("zhangsan") => println("hi, zhangsan")
      case Array(x, y) => println("hi, " + x + " , " + y)
      case Array("zhangsan", _*) => println("hi, zhangsan and other friends")
      case _ => println("hi, everybody")
    }
  }

  greeting(Array("zhangsan"))
  greeting(Array("lisi", "wangwu"))


  def greeting(list:List[String]): Unit ={
    list match {
      case "zhangsan" :: Nil => println("hi, zhangsan")
      case x :: y :: Nil => println("hi, " + x + " , " + y)
      case "zhangsan" :: tail => println("hi, zhangsan and other friends")
      case _ => println("hi, everybody")
    }
  }

  greeting(List("zhangsan"))
  greeting(List("lisi", "zhangsan"))
  greeting(List("zhangsan", "lisi", "wangwu"))
  greeting(List("lisi", "wangwu", "zhangsan"))


  def matchType(obj:Any): Unit ={
    obj match {
      case x:Int => println("Int")
      case s:String => println("String")
      case m:Map[_,_] => m.foreach(println)
      case _ => println("other type")
    }
  }

  matchType(Map("name" -> "PK"))

  def caseClassMatch(person: Person): Unit = {
    person match {
      case CTO(name, floor) => println("CTO name is " + name + ", floor is " + floor)
      case Employee(name, floor) => println("Employee name is: " + name + ", floor is " + floor)
      case _ => println("other")
    }
  }

  class Person
  case class CTO(name:String, floor:String) extends Person
  case class Employee(name:String, floor:String) extends Person
  case class Other(name:String) extends Person


  caseClassMatch(CTO("PK", "22"))
  caseClassMatch(Employee("zhangsan", "8"))
  caseClassMatch(Other("other"))
}
