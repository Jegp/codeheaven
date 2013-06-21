package codeheaven

import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import java.net.{Socket, ServerSocket}
import java.io.{OutputStreamWriter, PrintWriter}
import akka.actor.Status.Success

object Fetcher {

  def apply(socket : Socket) {
    val writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream))
    val f = future {
      val html = Source.fromFile("C:\\Users\\Daniel Varab\\Desktop\\Fiftylove.txt", "UTF-8").mkString
      writer.write(html)
      println(html)
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
      Fetcher(socket)

    }
  }
}