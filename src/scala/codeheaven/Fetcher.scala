package codeheaven

import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import java.net.{Socket, ServerSocket}
import java.io.{OutputStreamWriter, PrintWriter}
import akka.actor.Status.Success

object Fetcher {

  val root : String = "C:\\Users\\Daniel Varab\\IdeaProjects\\codeheaven\\src\\scala\\files\\"

  def apply(socket : Socket, path : String) {
    val f = future {
      //Client information, amateur logging
      val port = socket.getPort
      val endpoint = socket.getLocalAddress
      val origin = socket.getInetAddress
      println("Request from " + origin + ".")
      println("\tport: " + port)
      println("\tendpoint: " + endpoint)

      //Retrieve file from OS
      val html = Source.fromFile(root+path, "UTF-8").mkString

      //Create writer on socket and start writing to the body
      val writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream))
      writer.println("HTTP/1.1 200 OK")
      writer.println("Host: localhost")
      writer.println("Accept: */*")
      writer.println("User-Agent: Java")
      writer.println("Content-Length: " + html.length)
      writer.println() // Header -> Body separation. Is required
      writer.write(html)
      writer.flush()
    }

    f onSuccess {
      case _ => socket.close()
    }
  }

  def main(args : Array[String]) {
    val server = new ServerSocket(8080)
    while (true) {
      val socket = server.accept()
      Fetcher(socket, "html\\index.html")

    }
  }
}