package co.aa8y.leetcode

import org.scalatest.FunSpec

class BrokenCalculatorSpec extends FunSpec {
  describe("991. Broken Calculator") {
    import BrokenCalculator._

    describe("isOdd()") {
      it("should return true for an odd number.") {
        assert(isOdd(3) === true)
        assert(isOdd(79) === true)
      }
      it("should return false for a even number.") {
        assert(isOdd(2) === false)
        assert(isOdd(100) === false)
      }
    }
    describe("LeetCode") {
      it("Example #1") {
        val expected = 2
        val actual = brokenCalc(2, 3)

        assert(expected === actual)
      }
      it("Example #2") {
        val expected = 3
        val actual = brokenCalc(3, 10)

        assert(expected === actual)
      }
      it("Example #3") {
        val expected = 1023
        val actual = brokenCalc(1024, 1)

        assert(expected === actual)
      }
      it("Test case #X") {
        val expected = 39
        val actual = brokenCalc(1, 1000000000)

        assert(expected === actual)
      }
    }
  }
}
