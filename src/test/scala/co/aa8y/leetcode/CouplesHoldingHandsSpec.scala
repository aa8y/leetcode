package co.aa8y.leetcode

import org.scalatest.FunSpec

class CouplesHoldingHandsSpec extends FunSpec {
  describe("765. Couples Holding Hands") {
    import CouplesHoldingHands._

    describe("getCouple()") {
      it("should get the couple for a given number.") {
        assert(getCouple(0) === 1)
        assert(getCouple(3) === 2)
      }
    }
    describe("isCouple()") {
      it("should return true for a couple in any order.") {
        assert(isCouple(0, 1))
        assert(isCouple(3, 2))
      }
      it("should return false for obvious non-couples.") {
        assert(!isCouple(0, 3))
        assert(!isCouple(5, 2))
      }
      it("should detect consecutive numbers which are not couples.") {
        assert(!isCouple(1, 2))
        assert(!isCouple(4, 3))
      }
    }
    /*
    describe("minSwapsCouples()") {
      it("should not swap a sorted array.") {
        val row = Array(0, 1, 2, 3)
        assert(minSwapsCouples(row) === 0)
      }
      it("2") {
        val row = Array(1, 2, 0, 3)
        assert(minSwapsCouples(row) === 1)
      }
      it("3") {
        val row = Array(2, 1, 0, 3)
        assert(minSwapsCouples(row) === 2)
      }
    }
    describe("LeetCode") {
      it("Example #1") {
        val row = Array(0, 2, 1, 3)
        assert(minSwapsCouples(row) === 1)
      }
      it("Example #2") {
        val row = Array(3, 2, 0, 1)
        assert(minSwapsCouples(row) === 0)
      }
      it("Test case #3") {
        val row = Array(2, 0, 5, 4, 3, 1)
        assert(minSwapsCouples(row) === 0)
      }
    }
    */
  }
}
