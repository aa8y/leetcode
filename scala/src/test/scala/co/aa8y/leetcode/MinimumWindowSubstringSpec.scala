package co.aa8y.leetcode

import org.scalatest.FunSpec

class MinimumWindowSubstringSpec extends FunSpec {
  describe("76. Minimum Window Substring") {
    import MinimumWindowSubstring._

    describe("MinimumWindowSubstring") {
      it("should foo.") {
      }
    }
    describe("LeetCode") {
      it("Example #1") {
        val expected = "BANC"
        val actual = minWindow("ADOBECODEBANC", "ABC")

        assert(expected === actual)
      }
      it("Test case #51") {
        val expected = ""
        val actual = minWindow("a", "aa")

        assert(expected === actual)
      }
      /*
      it("Test case #156") {
        val expected = "ab"
        val actual = minWindow("bdab", "ab")

        assert(expected === actual)
      }
      */
    }
  }
}
