package solution.day03

import org.scalatest.FunSuite

class Day03Test extends FunSuite {

  test("Day03.problemA") {

    assert(Day03.problemA(">") === 2)
    assert(Day03.problemA("^>v<") === 4)
    assert(Day03.problemA("^v^v^v^v^v") === 2)

  }

  test("Day03.problemB") {

    assert(Day03.problemB("^v") === 3)
    assert(Day03.problemB("^>v<") === 3)
    assert(Day03.problemB("^v^v^v^v^v") === 11)

  }

}
