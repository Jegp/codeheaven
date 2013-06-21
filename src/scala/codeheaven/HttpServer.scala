package codeheaven

import java.net.{Socket, ServerSocket}
import java.io.{OutputStreamWriter, InputStreamReader, BufferedReader, PrintWriter}
import java.util.Scanner

/**
 * The HTTP entry-point for codeheaven.
 */
object HttpServer {

  def main(args : Array[String]) {
    val server = new ServerSocket(8080)
    while (true) {
      val socket = server.accept()
      val writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream))
      writer.println("HTTP/1.1 200 OK")
      writer.println("Host: localhost")
      writer.println("Accept: */*")
      writer.println("User-Agent: Java") // Be honest.
      writer.println("Content-Length: 11")
      writer.println() // Important, else the server will expect that there's more into the request.
      writer.print("Hello world")
      writer.flush()


      writer.close()
      socket.close()
    }
  }

}
