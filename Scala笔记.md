#  Scala笔记

### 基本语法

- Val vs var

  - val：值 类比与final ，一般写法为 val 值名称：类型 = xxx，但是大部分情况能够做类型推断
  - var：变量，一般写法为：var 值名称：类型 = xxx

- lazy在Scala中的应用

- 基本数据类型

  - Byte/Char
  - Short/Int/Long/Float/Double
  - Boolean
  - asInstanceOf/isInstanceOf

- Scala开发工具

  - IDEA：需要自己安装Scala插件

- Scala函数

  - 方法的定义和使用

    - def 方法名(参数名：参数类型)：返回值类型 = {

      ​        //括号内的方法体

      ​        //方法体内的最后一行为返回值，不需要使用return

      }

  - 默认参数的使用

    - 在函数定义时，允许指定参数的默认值，default值  

  - 命名参数的使用

  - 可变参数的使用

    - 传入多个参数

  - 条件表达式

  - 循环表达式

    - to:闭区间
    - range：左闭右开区间
    - Until：左闭右开区间

- Scala面向对象

  - 面向对象概述
    - 封装
      - 属性，方法封装到类中
    - 继承
      - 父类和子类之间的关系
    - 多态
      -  父类引用指向子类对象
  - 类的定义和使用
  - 构造器
  - 继承与重写
  - 抽象类
  - 伴生类和伴生对象
  - apply
  - case class
  - trait
    - 类似于interface接口
    - 多个trait 之间用with 第一个用extends
    - xxx extends ATrait with BTrait

- Scala集合

  - 数组
    - 定长
    - 变长
  - List
  - Set
  - Map
  - Option&Some&None
  - Tuple

- 模式匹配：在Java中第一个值进行条件判断，返回针对不同的条件进行不同的处理

  - 变量 match {

    ​      case value1 => 代码1

    ​      case value2 => 代码2

    }

  - 基本数据类型模式匹配

  - Scala异常处理

  - Array模式匹配

  - case class模式匹配

  - List模式匹配

  - Some&None模式匹配

- Scala函数高级操作

  - 字符串高级操作
    - 多行
    - Interpolation：插值
  - currying函数
  - 高阶函数

- Scala隐式转换

  - 隐式转换概述
  - 为一个已存在的类添加一个新的方法，Java中可以使用动态代理，Scala中使用隐式转换
  - 隐式参数：指的是在函数或者方法中，定义一个用implicit修饰的参数，此时Scala会尝试找到一个指定的类型的，用implicit修饰的对象，即隐式值，并注入参数
  - 隐式类

- Scala操作外部数据

  - 操作文件
  - 操作xml