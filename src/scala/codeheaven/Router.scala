package codeheaven

/**
 * Created with IntelliJ IDEA.
 * User: Daniel Varab
 * Date: 21-06-13
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */
object Router {
  def apply(route : String) : String = route match{
    case "/" => "html\\index.html"
    case "/cage" => "html\\login.html" // nonesense yes.
  }

}
