package codeheaven

import java.io.InputStream

/**
 * Created with IntelliJ IDEA.
 * User: Daniel Varab
 * Date: 21-06-13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
object NetworkUtil {

  def parseHttpRequest(requestStream : InputStream) : String = {
    val buffer : Array[Byte] = new Array[Byte](500)
    requestStream.read(buffer)

    val request = new String(buffer)
    var list = request.split(" ")
    println(list(1))
    return Router(list(1))
  }

}
