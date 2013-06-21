package codeheaven

import java.net.ServerSocket

/**
 * Created with IntelliJ IDEA.
 * User: Daniel Varab
 * Date: 21-06-13
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
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
