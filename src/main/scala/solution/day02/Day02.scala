package solution.day02

import solution._

object Day02 extends Day(2) {

  case class Dimension(length: Int, width: Int, height: Int) {

    val a = length * width
    val b = width * height
    val c = height * length

    lazy val surfaceArea: Int = (2 * a) + (2 * b) + (2 * c)
    lazy val smallestSideArea: Int = {
      Seq(b, c).foldLeft(a)((min, next) => Math.min(min, next))
    }

    lazy val smallestSidePerimeter: Int = {
      val a = 2 * (length + width)
      val b = 2 * (width + height)
      val c = 2 * (height + length)
      Seq(b, c).foldLeft(a)((min, next) => Math.min(min, next))
    }

    lazy val cubicVolume = length * width * height

    lazy val requiredWrappingPaper: Int = surfaceArea + smallestSideArea
    lazy val requiredRibbon: Int = smallestSidePerimeter + cubicVolume
  }

  object Dimension {
    def apply(input: String): Dimension = {
      val dims = input.split("x").map(_.toInt)
      Dimension(dims(0), dims(1), dims(2))
    }
  }

  /**
    * Problem A
    * @param input
    * @return
    */
  def problemA(input: String): Int = {
    input.split("\n").map { d =>
      Dimension(d).requiredWrappingPaper
    }.sum
  }

  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: String): Int = {
    input.split("\n").map { d =>
      Dimension(d).requiredRibbon
    }.sum
  }

  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
