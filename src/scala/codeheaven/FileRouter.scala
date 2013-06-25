package codeheaven

import java.io.File

/**
 * A router that maps HTTP requests to files
 */
object FileRouter {

  def apply(route : String) : String = route match{
    case "/" | "" => "index.html"
    case "/login" => "login.html"
    case "/cage" => "login.html" // nonesense yes.
  }

}
