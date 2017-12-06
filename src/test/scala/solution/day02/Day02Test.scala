package solution.day02

import org.scalatest.FunSuite
import solution.day02.Day02.Dimension

class Day02Test extends FunSuite {

  test("Dimension.requiredWrappingPaper") {

    assert(Dimension("2x3x4").requiredWrappingPaper === 58)
    assert(Dimension("1x1x10").requiredWrappingPaper === 43)

  }

  test("Dimension.requiredRibbon") {

    assert(Dimension("2x3x4").requiredRibbon === 34)
    assert(Dimension("1x1x10").requiredRibbon === 14)

  }

}
