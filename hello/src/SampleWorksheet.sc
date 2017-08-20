object SampleWorksheet {
  def hello(name: String): String = s"Hello, ${name}"

  hello("katsura")

  def add(x: Int, y: Int): Int = x + y

  val z = add(1, 2)

  add(3, 4)

  val a = 1
  if (a == 1) a
  if (a != 1) "not one"
  if (a != 1) "not one" else a

  val l = List("alice", "bob", "gui")
  for (
    s <- l
  ) println(s)

  for{
    s <- l
    if (s.length > 3)
  }println(s)

  val result_for = for {
    s <- l
    s1 = s.toUpperCase()
    if (s1 != "")
  }println(s1)

  try {
    Integer.parseInt("dog")
  } catch {
    case _ => 0
  } finally {
    println("always be printed")
  }

  val code = 3
  code match {
    case 1 => "one"
    case 2 => "two"
    case _ => "others"
  }

  def sum(f: Int => Int)(a: Int)(b: Int): Int = {

    @annotation.tailrec
    def loop(n: Int, acc: Int): Int = {
      if(n > b) {
        println(s"n = ${n}, acc = ${acc}")
        acc
      } else {
        println(s"n = ${n}, acc = ${acc}")
        loop(n + 1, acc + f(n))
      }
    }

    loop(a, 0)
  }

  sum (x => x)(1)(5)

  sum (x => x * x)(1)(5)

  sum (x => x * x * x)(1)(5)


}

import java.net.{Socket, ServerSocket}
import java.util.concurrent.{Executors, ExecutorService}
import java.util.Date

class NetworkService(port: Int, poolSize: Int) extends Runnable {
  val serverSocket = new ServerSocket(port)

  def run() {
    while (true) {
      // This will block until a connection comes in.
      val socket = serverSocket.accept()
      (new Handler(socket)).run()
    }
  }
}

class Handler(socket: Socket) extends Runnable {
  def message = (Thread.currentThread.getName() + "\n").getBytes

  def run() {
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
}

(new NetworkService(2020, 2)).run