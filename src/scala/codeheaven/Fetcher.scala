package codeheaven

import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global
import java.net.{Socket, ServerSocket}
import java.io.{File, OutputStream, OutputStreamWriter, PrintWriter}

object Fetcher {

  /*
   * Probably not needed to thread this. Remove next commit.
   */
  def apply(outputStream : OutputStream, path : String) {
    //Retrieve file from OS
    val html = Source.fromFile(path, "UTF-8").mkString

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

    outputStream.close()
  }
}