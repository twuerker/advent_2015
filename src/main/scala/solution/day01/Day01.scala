package solution.day01

import solution._

object Day01 extends Day(1) {

  def findFloor(input: String): Int = {
    val counts = input.split("").foldLeft((0,0))((counts, s) => {
      s match {
        case "(" => (counts._1 + 1, counts._2)
        case ")" => (counts._1, counts._2 + 1)
        case _ => counts
      }
    })
    counts._1 - counts._2
  }

  def entersBasementAt(input: String): Int = {

    def loop(step: Int, floor: Int, remaining: Vector[String]): Int = {
      if (floor <= -1) {
        step
      } else {
        remaining.headOption match {
          case None => -10
          case Some(nextString) => {
            val nextFloor = nextString match {
              case "(" => floor + 1
              case ")" => floor - 1
              case _ => floor
            }
            loop(step + 1, nextFloor, remaining.tail)
          }

        }
      }
    }
    loop(0, 0, input.split("").toVector)
  }

  /**
    * Problem A
    * @param input
    * @return
    */
  def problemA(input: String): Int = {
    findFloor(input)
  }

  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    * @return
    */
  def problemB(input: String): Int = {
    entersBasementAt(input)
  }

  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
