package codeheaven

object NetworkUtil {

  def getHttpPath(request : String) : String = {
    val requestSplit = request.split(" ")
    return FileRouter(requestSplit(1))
  }

  def getHttpMethod(request : String) : String = {
    val requestSplit = request.split(" ")
    return requestSplit(0)
  }

  def getHttpBody(request : String) : String = {
    //get last 'word', which should consequently be the body
    //very vulnerable to attacks at the current time yes
    return request.substring(request.lastIndexOf(" ")+1)
  }
}
