package codeheaven

import java.io.File

/**
 * A router that maps HTTP requests to files
 */
object FileRouter {

  val root : String = new File("").getAbsolutePath + File.separator + "www" + File.separator

  def apply(route : String) : String = root + (
    route match{
    case "/" | "" => "index.html"
    case file : String if new File(root + file).exists() => file
    case file : String if new File(root + file + ".html").exists() => file + ".html"
    case _ => "404.html"
  })

}
