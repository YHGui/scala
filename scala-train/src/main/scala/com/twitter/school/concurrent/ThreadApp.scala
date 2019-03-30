package com.twitter.school.concurrent

import java.net.{ServerSocket, Socket}
import java.util.concurrent.{ExecutorService, Executors}

/**
  * Created by guiyonghui on 2018/9/30.
  */
object ThreadApp {
  def main(args: Array[String]): Unit = {
    (new NetworkService(2020, 2)).run()
  }

}

class NetworkService(port: Int, poolSize: Int) extends Runnable{
  val serverSocket = new ServerSocket(port)
  val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)

  override def run(): Unit = {
    println("=========socket=========")

    try {
      while (true) {
        val socket = serverSocket.accept()
        pool.execute(new Handler(socket))
      }
    } finally {
      pool.shutdown()
    }

  }
}

class Handler(socket: Socket) extends Runnable {
  val message = (Thread.currentThread.getName() + "\n").getBytes

  override def run(): Unit = {
    println("========handler=======")
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
}


