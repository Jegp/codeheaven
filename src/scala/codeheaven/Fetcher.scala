package codeheaven

import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import java.net.{Socket, ServerSocket}
import java.io.{OutputStream, OutputStreamWriter, PrintWriter}

object Fetcher {

  val root : String = "C:\\Users\\Daniel Varab\\IdeaProjects\\codeheaven\\src\\scala\\files\\"

  def apply(outputStream : OutputStream, path : String) {
    val f = future {
      //Retrieve file from OS
      val html = Source.fromFile(root+path, "UTF-8").mkString

      //Create writer on socket and start writing to the body
      val writer = new PrintWriter(new OutputStreamWriter(outputStream))
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
      case _ => outputStream.close()
    }
  }
}