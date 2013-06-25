package codeheaven

import java.io._
import java.net.Socket
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.io.{BufferedSource, Source}


object Dispatcher {

  def apply(socket : Socket) {

    val f = future {

      //retrieve strin from buffer
      val buffer : Array[Byte] = new Array[Byte](500)
      socket.getInputStream.read(buffer)
      val request = new String(buffer)

      //retrieve path from http request
      val path = NetworkUtil.getHttpPath(request)
      //retrieve method from http request
      val httpMethod = NetworkUtil.getHttpMethod(request)

      //TO-DO: Case scenario based on method
      Fetcher(socket.getOutputStream, path)

    }
  }
}
