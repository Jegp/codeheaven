package codeheaven

import scala.util.matching.Regex


/*
 * Discarded feature as of now, but uploaded for future usage of
 * embedded behavior of the filesystem.
 */
object DataInjector {
  //regex doesn't work as of now duo to the reasoning of multiple cases
  val regexInjector = """(\{)([^)]*)(\})""".r
  def apply(html : String) {
    regexInjector.findAllIn(html).matchData foreach {
        case result => println(result.group(2)) // fix to return modified string for embedded data
    }
  }
}
