package co.aa8y.leetcode

import org.scalatest.{FunSpec, Ignore}

@Ignore
class LargestPlusSignSpec extends FunSpec {
  describe("764. Largest Plus Sign") {
    import LargestPlusSign._
    
    val mineless = Array.empty[Array[Int]]

    describe("orderOfLargestPlusSign()") {
      it("should return 0 for a 0x0 matrix.") {
        assert(orderOfLargestPlusSign(0, mineless) === 0)
      }
      it("should return 1 for a 1x1 matrix with no mines.") {
        assert(orderOfLargestPlusSign(1, mineless) === 1)
      }
      it("should return 0 for a 1x1 matrix with a mine.") {
        assert(orderOfLargestPlusSign(1, Array(Array(0, 0))) === 0)
      }
    }
    describe("LeetCode") {
      it("Example #1") {
        assert(orderOfLargestPlusSign(5, Array(Array(4, 2))) === 2)
      }
      it("Example #2") {
        assert(orderOfLargestPlusSign(2, mineless) === 1)
      }
      it("Example #3") {
        assert(orderOfLargestPlusSign(1, Array(Array(0, 0))) === 0)
      }
      it("Test case #16") {
        val mines = Array(Array(0, 1), Array(1, 0), Array(1, 1))

        assert(orderOfLargestPlusSign(2, mines) === 1)
      }
      it("Test case #19") {
        val mines = Array(Array(0, 0), Array(1, 1))

        assert(orderOfLargestPlusSign(2, mines) === 1)
      }
      /*
      it("Test case #20") {
        val mines = Array(Array(0, 0), Array(0, 1), Array(1, 1))

        assert(orderOfLargestPlusSign(2, mines) === 1)
      }
      */
    }
  }
}
