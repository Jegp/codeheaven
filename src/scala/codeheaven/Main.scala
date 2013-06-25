package codeheaven

import java.net.ServerSocket

object Main {
  def main(args : Array[String]) {
    val server = new ServerSocket(8080)
    while (true) {
      val socket = server.accept()
      Dispatcher(socket)
    }
  }
}
