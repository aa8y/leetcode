package co.aa8y.leetcode

import org.scalatest.FunSpec

class ThreeSumSpec extends FunSpec {
  describe("15. 3Sum") {
    import ThreeSum._

    describe("LeetCode") {
      it("Example #1") {
        val nums = Array(-1, 0, 1, 2, -1, -4)
        val expected = List(
          List(-1, 0, 1),
          List(-1, -1, 2)
        )
        val actual = threeSum(nums)

        assert(expected === actual)
      }
      it("TestCase #313") {
        val nums = Array.fill(3000)(0)
        val expected = List(0, 0, 0) :: Nil
        val actual = threeSum(nums)

        assert(expected === actual)
      }
    }
  }
}
