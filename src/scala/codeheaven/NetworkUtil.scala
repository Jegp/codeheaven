package codeheaven

import java.io.InputStream

object NetworkUtil {

  def getHttpPath(request : String) : String = {
    val requestSplit = request.split(" ")
    println(requestSplit(1))
    return FileRouter(requestSplit(1))
  }

  def getHttpMethod(request : String) : String = {
    val requestSplit = request.split(" ")
    println(requestSplit(0))
    return requestSplit(0)
  }

}
