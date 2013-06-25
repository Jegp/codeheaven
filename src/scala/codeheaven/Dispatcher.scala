package codeheaven

import java.io._
import java.net.Socket
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.io.{BufferedSource, Source}


object Dispatcher {

  def apply(socket : Socket) {

    val f = future {

      //retrieve string from buffer
      val buffer : Array[Byte] = new Array[Byte](500)
      socket.getInputStream.read(buffer)
      val request = new String(buffer)

      //retrieve path from http request
      val path = NetworkUtil.getHttpPath(request)
      //retrieve method from http request
      val httpMethod = NetworkUtil.getHttpMethod(request)

      println("Request: Path - " + path + " HTTP Method - " + httpMethod)

      httpMethod match {
        case "GET" => Fetcher(socket.getOutputStream, path)
          //ugly ass code.. but its there to work until data module has been written
          //for real implementation references to a data post method which should return a redirection
          //status code (300-400)
        case "POST" => {
          val response = NetworkUtil.getHttpBody(request)
          val stream = socket.getOutputStream
          val writer = new PrintWriter(new OutputStreamWriter(stream))
          writer.println("HTTP/1.1 200 OK")
          writer.println("Host: localhost")
          writer.println("Accept: */*")
          writer.println("Content-Length: " + response.length)
          writer.println() // Header -> Body separation. Is required
          writer.println(response)
          writer.flush
          stream.close
        }
        case _ => Fetcher(socket.getOutputStream, "ERROR") //String is for simplicity, should be routed to the "else" case in the fetcher
      }
    }

    f onSuccess{
      case _ => socket.close
    }
  }
}
