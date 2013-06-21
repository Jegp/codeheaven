package codeheaven

import java.io._
import java.net.Socket
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.io.{BufferedSource, Source}


object Dispatcher {

  def apply(socket : Socket) {

    val f = future {
      val endpoint = NetworkUtil.parseHttpRequest(socket.getInputStream)
      Fetcher(socket.getOutputStream, endpoint)

    }
  }

}
