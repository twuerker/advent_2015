package solution.day05

import solution._

object Day05 extends Day(5) {

  def containsThreeVowels(str: String): Boolean = {
    val numVowels = str.split("").count( s => "aeiou".contains(s))
    numVowels >= 3
  }

  def containsDoubleLetter(str: String): Boolean = {
    def loop(previous: String, remaining: Vector[String]): Boolean  = {
      remaining.headOption match {
        case None => false
        case Some(current) => {
          if (current.equalsIgnoreCase(previous)) true
          else loop(current, remaining.tail)
        }
      }
    }
    loop("", str.split("").toVector)
  }

  def doesNotContainBadCombos(str: String): Boolean = {
    def loop(remaining: Vector[String]): Boolean  = {
      remaining.headOption match {
        case None => true
        case Some(badCombo) => {
          if (str.contains(badCombo)) false
          else loop(remaining.tail)
        }
      }
    }
    val badCombos = Vector("ab", "cd", "pq", "xy")
    loop(badCombos)
  }

  def isNiceA(str: String): Boolean = {
    val rule1 = containsThreeVowels(str)
    val rule2 = containsDoubleLetter(str)
    val rule3 = doesNotContainBadCombos(str)
    rule1 && rule2 && rule3
  }

  def containsPairWithoutOverlap(str: String): Boolean = {
    def loop(seen: Set[String], overlappingPair: String, remaining: Vector[String]): Boolean = {
      if (remaining.length <= 1) false
      else {
        val pair = remaining.take(2).mkString("")
        if (seen.contains(pair)) true
        else loop(seen + overlappingPair, pair, remaining.tail)
      }
    }
    val strVector = str.split("").toVector
    if (strVector.length < 4) false
    else {
      val firstPair = strVector.take(2).mkString("")
      val secondPair = strVector.take(3).drop(1).mkString("")
      loop(Set(firstPair), secondPair, strVector.drop(2))
    }
  }

  def containsRepeatedLetterAfterOne(str: String): Boolean = {
    def loop(n_2: String, n_1: String, remaining: Vector[String]): Boolean = {
      remaining.headOption match {
        case None => false
        case Some(current) => {
          if (current.equalsIgnoreCase(n_2)) true
          else loop(n_1, current, remaining.tail)
        }
      }
    }
    val chars = str.split("")
    if (chars.length <= 2) false
    else loop(chars(0), chars(1), chars.drop(2).toVector)
  }

  def isNiceB(str: String): Boolean = {
    val rule1 = containsPairWithoutOverlap(str)
    val rule2 = containsRepeatedLetterAfterOne(str)
    rule1 && rule2
  }

  /**
    * Problem A
    * @param input
    */
  def problemA(input: String) = {
    val strings = input.split("\n")
    strings.count(s => isNiceA(s))
  }
  val solutionA = problemA(input)
  finalAnswer(solutionA.toString, A)

  /**
    * Problem B
    * @param input
    */
  def problemB(input: String) = {
    val strings = input.split("\n")
    strings.count(s => isNiceB(s))
  }
  val solutionB = problemB(input)
  finalAnswer(solutionB.toString, B)

}
