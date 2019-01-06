package co.aa8y.leetcode

import org.scalatest.FunSpec

class PowerfulIntegersSpec extends FunSpec {
  describe("970. Powerful Integers") {
    import PowerfulIntegers._

    describe("LeetCode") {
      it("Example #1") {
        val expected = List(2, 3, 4, 5, 7, 9, 10)
        val actual = powerfulIntegers(2, 3, 10).sorted

        assert(expected === actual)
      }
      it("Example #2") {
        val expected = List(2, 4, 6, 8, 10, 14)
        val actual = powerfulIntegers(3, 5, 15).sorted

        assert(expected === actual)
      }
    }
  }
}
