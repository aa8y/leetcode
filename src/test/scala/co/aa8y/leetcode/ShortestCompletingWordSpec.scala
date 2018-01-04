package co.aa8y.leetcode

import org.scalatest.FunSpec

class ShortestCompletingWordSpec extends FunSpec {
  describe("Problem 749: Shortest Completing Word") {
    import ShortestCompletingWord._

    describe("getLetters()") {
    }
    describe("shortestCompletingWord()") {
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
