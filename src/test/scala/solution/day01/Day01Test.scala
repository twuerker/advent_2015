package solution.day01

import org.scalatest.FunSuite


class Day01Test extends FunSuite {

  test("Day01.findFloor") {

    assert(Day01.findFloor("(())") === 0)
    assert(Day01.findFloor("()()") === 0)
    assert(Day01.findFloor("(((") === 3)
    assert(Day01.findFloor("(()(()(") === 3)
    assert(Day01.findFloor("))(((((") === 3)
    assert(Day01.findFloor("())") === -1)
    assert(Day01.findFloor("))(") === -1)
    assert(Day01.findFloor(")))") === -3)
    assert(Day01.findFloor(")())())") === -3)

  }

  test("Day01.entersBasementAt") {

    assert(Day01.entersBasementAt(")") === 1)
    assert(Day01.entersBasementAt("()())") === 5)

  }

}
