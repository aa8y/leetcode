package co.aa8y.leetcode

import org.scalatest.FunSpec

class RomanToIntegerSpec extends FunSpec {
  describe("Problem 0013: Roman to Integer") {
    import RomanToInteger._

    describe("LeetCode") {
      it("Example #1") {
        assert(3 === romanToInt("III"))
      }
      it("Example #2") {
        assert(4 === romanToInt("IV"))
      }
      it("Example #3") {
        assert(9 === romanToInt("IX"))
      }
      it("Example #4") {
        assert(58 === romanToInt("LVIII"))
      }
      it("Example #5") {
        assert(1994 === romanToInt("MCMXCIV"))
      }
    }
  }
}
