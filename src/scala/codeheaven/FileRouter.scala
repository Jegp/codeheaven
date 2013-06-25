package codeheaven

import java.io.File

/**
 * A router that maps HTTP requests to files
 */
object FileRouter {

  def apply(route : String) : String = route match{
    case "/" | "" => "html\\index.html"
    case "/login" => "html\\login.html"
    case "/cage" => "html\\login.html" // nonesense yes.
  }

}
