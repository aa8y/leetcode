package co.aa8y.leetcode

import org.scalatest.FunSpec

class ShortestCompletingWordSpec extends FunSpec {
  describe("Problem 749: Shortest Completing Word") {
    import ShortestCompletingWord._

    val emptyMap = Map[Char, Int]()
    val foo = Map('f' -> 1, 'o' -> 2)
    val foobar = Map('f' -> 1, 'o' -> 2, 'b' -> 1, 'a' -> 1, 'r' -> 1)

    describe("getLetterFreq()") {
      it("should return an empty map for an empty string.") {
        assert(getLetterFreq("") === emptyMap)
      }
      it("should return an empty map for a string with no letters.") {
        assert(getLetterFreq("900123") === emptyMap)
      }
      it("should return a map with letter frequencies.") {
        val computed = getLetterFreq("foobar")
        assert(computed === foobar)
      }
      it("should ignore non-letter characters.") {
        val expected = Map('l' -> 1, 't' -> 1, 'c' -> 1, 'd' -> 1)
        val computed = getLetterFreq("l33tc0d3")

        assert(computed === expected)
      }
      it("should convert letters to lowercase.") {
        val computed = getLetterFreq("fOoBaR")
        assert(computed === foobar)
      }
    }
    describe("isComplete()") {
      it("should return true for empty maps.") {
        assert(isComplete(emptyMap, emptyMap))
      }
      it("should return true for the same maps.") {
        assert(isComplete(foobar, foobar))
      }
      it("should return true when the word completes the license.") {
        assert(isComplete(foo, foobar))
      }
      it("should return false when the word does not complete the license.") {
        assert(!isComplete(foobar, foo))
      }
    }
    describe("LeetCode") {
      it("Example #1") {
        val licensePlate = "1s3 PSt"
        val words = Array("step", "steps", "stripe", "stepple")

        assert(shortestCompletingWord(licensePlate, words) === "steps")
      }
      it("Example #2") {
        val licensePlate = "1s3 456"
        val words = Array("looks", "pest", "stew", "show")

        assert(shortestCompletingWord(licensePlate, words) === "pest")
      }
      it("Unknown test case #1") {
        val licensePlate = "Ah71752"
        val words = Array("suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old")

        assert(shortestCompletingWord(licensePlate, words) === "husband")
      }
      it("Unknown test case #2") {
        val licensePlate = "OgEu755"
        val words = Array("enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus")

        assert(shortestCompletingWord(licensePlate, words) === "enough")
      }
    }
  }
}
