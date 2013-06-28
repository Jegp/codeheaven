package codeheaven

object NetworkUtil {

  /*
   * Inspects the http string body and returns the path.
   * - Expected to be unstable duo the to lack of regex.
   */
  def getHttpPath(request : String) : String = {
    val requestSplit = request.split(" ")
    return FileRouter(requestSplit(1))
  }

  /*
  * Inspects the http request and returns the HTTP method.
  * - Expected to be unstable duo the to lack of regex.
  */
  def getHttpMethod(request : String) : String = {
    val requestSplit = request.split(" ")
    return requestSplit(0)
  }

  /*
 * Inspects the http string and returns the body of the given request.
 * - Expected to be unstable duo the to lack of regex.
 */
  def getHttpBody(request : String) : String = {
    //get last 'word', which should consequently be the body
    //very vulnerable to attacks at the current time yes
    return request.substring(request.lastIndexOf(" ")+1)
  }
}
