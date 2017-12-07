package solution.day04

import solution._

object Day04 extends Day(4) {

  def md5Hash(text: String) : String = {
    java.security.MessageDigest.getInstance("MD5")
      .digest(text.getBytes())
      .map(0xFF & _)
      .map { "%02x".format(_) }
      .foldLeft(""){_ + _}
  }

  def findHashStartsWith(startsWith: String) = {
    def loop(i: Int): Int = {
      val text = s"$input$i"
      if (md5Hash(text).startsWith(startsWith)) {
        i
      } else {
        loop(i + 1)
      }
    }
    loop(1)
  }

  /**
    * Problem A
    * @param input
    */
  def problemA(input: String) = {
    findHashStartsWith("00000")
  }
  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    */
  def problemB(input: String) = {
    findHashStartsWith("000000")

  }
  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
