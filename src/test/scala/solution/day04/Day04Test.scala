package solution.day04

import org.scalatest.FunSuite

class Day04Test extends FunSuite {

  test("Day04.md5Hash") {
    assert(Day04.md5Hash("abcdef609043").startsWith("00000"))
    assert(Day04.md5Hash("pqrstuv1048970").startsWith("00000"))
  }

  test("Day04.problemA") {

    assert(Day04.problemA("abcdef") === 609043)
    assert(Day04.problemA("pqrstuv") === 1048970)

  }

}
