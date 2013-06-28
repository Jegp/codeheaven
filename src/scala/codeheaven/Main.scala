package codeheaven

import java.net.ServerSocket

/*
 * Initialize a server socket receíving raw data being threaded to the
 * future object Dispatcher.
 */
object Main {
  def main(args : Array[String]) {
    val server = new ServerSocket(8080)
    while (true) {
      val socket = server.accept()
      Dispatcher(socket)
    }
  }
}
