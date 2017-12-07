package solution.day05

import org.scalatest.FunSuite

class Day05Test extends FunSuite {

  test("Day05.containsThreeVowels") {
    assert(Day05.containsThreeVowels("aei") === true)
    assert(Day05.containsThreeVowels("xazegov") === true)
    assert(Day05.containsThreeVowels("aeiouaeiouaeiou") === true)

    assert(Day05.containsThreeVowels("ugknbfddgicrmopn") === true)
    assert(Day05.containsThreeVowels("aaa") === true)
    assert(Day05.containsThreeVowels("dvszwmarrgswjxmb") === false)
  }

  test("Day05.containsDoubleLetter") {
    assert(Day05.containsDoubleLetter("xx") === true)
    assert(Day05.containsDoubleLetter("abcdde") === true)
    assert(Day05.containsDoubleLetter("aabbccdd") === true)

    assert(Day05.containsDoubleLetter("ugknbfddgicrmopn") === true)
    assert(Day05.containsDoubleLetter("aaa") === true)
    assert(Day05.containsDoubleLetter("jchzalrnumimnmhp") === false)
  }

  test("Day05.doesNotContainBadCombos") {
    assert(Day05.doesNotContainBadCombos("ab") === false)
    assert(Day05.doesNotContainBadCombos("cd") === false)
    assert(Day05.doesNotContainBadCombos("pq") === false)
    assert(Day05.doesNotContainBadCombos("xy") === false)

    assert(Day05.doesNotContainBadCombos("ugknbfddgicrmopn") === true)
    assert(Day05.doesNotContainBadCombos("aaa") === true)
    assert(Day05.doesNotContainBadCombos("haegwjzuvuyypxyu") === false)
  }

  test("Day05.isNiceA") {
    assert(Day05.isNiceA("ugknbfddgicrmopn") === true)
    assert(Day05.isNiceA("aaa") === true)
    assert(Day05.isNiceA("jchzalrnumimnmhp") === false)
    assert(Day05.isNiceA("haegwjzuvuyypxyu") === false)
    assert(Day05.isNiceA("dvszwmarrgswjxmb") === false)
  }

  test("Day05.containsPairWithoutOverlap") {
    assert(Day05.containsPairWithoutOverlap("xyxy") === true)
    assert(Day05.containsPairWithoutOverlap("aabcdefgaa") === true)
    assert(Day05.containsPairWithoutOverlap("aaa") === false)

    assert(Day05.containsPairWithoutOverlap("qjhvhtzxzqqjkmpb") === true)
    assert(Day05.containsPairWithoutOverlap("xxyxx") === true)
    assert(Day05.containsPairWithoutOverlap("uurcxstgmygtbstg") === true)
    assert(Day05.containsPairWithoutOverlap("ieodomkazucvgmuy") === false)
  }

  test("Day05.containsRepeatedLetterAfterOne") {
    assert(Day05.containsRepeatedLetterAfterOne("xyx") === true)
    assert(Day05.containsRepeatedLetterAfterOne("abcdefeghi") === true)
    assert(Day05.containsRepeatedLetterAfterOne("aaa") === true)

    assert(Day05.containsRepeatedLetterAfterOne("qjhvhtzxzqqjkmpb") === true)
    assert(Day05.containsRepeatedLetterAfterOne("xxyxx") === true)
    assert(Day05.containsRepeatedLetterAfterOne("uurcxstgmygtbstg") === false)
    assert(Day05.containsRepeatedLetterAfterOne("ieodomkazucvgmuy") === true)
  }

  test("Day05.isNiceB") {
    assert(Day05.isNiceB("qjhvhtzxzqqjkmpb") === true)
    assert(Day05.isNiceB("xxyxx") === true)
    assert(Day05.isNiceB("uurcxstgmygtbstg") === false)
    assert(Day05.isNiceB("ieodomkazucvgmuy") === false)
  }

}
