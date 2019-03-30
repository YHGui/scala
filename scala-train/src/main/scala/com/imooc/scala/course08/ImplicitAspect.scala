package com.imooc.scala.course08

import java.io.File

/**
  * Created by guiyonghui on 2018/9/25.
  */
object ImplicitAspect {

  implicit def man2superman(man:Man):Superman = new Superman(man.name)


  implicit def file2RichFile(file: File):RichFile = new RichFile(file)

}
