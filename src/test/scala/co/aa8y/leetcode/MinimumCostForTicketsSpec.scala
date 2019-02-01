
package co.aa8y.leetcode

import org.scalatest.FunSpec

class MinimumCostForTicketsSpec extends FunSpec {
  describe("983. Minimum Cost For Tickets") {
    import MinimumCostForTickets._

    describe("LeetCode") {
      it("Example #1") {
        val days = Array(1, 4, 6, 7, 8, 20)
        val costs = Array(2, 7, 15)
        val expected = 11
        val actual = mincostTickets(days, costs)

        assert(expected === actual)
      }
      it("Example #2") {
        val days = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31)
        val costs = Array(2, 7, 15)
        val expected = 17
        val actual = mincostTickets(days, costs)

        assert(expected === actual)
      }
    }
    describe("Custom") {
      it("Test case #1") {
        val days = Array(1, 4, 6, 7, 8, 9, 20)
        val costs = Array(2, 7, 15)
        val expected = 11
        val actual = mincostTickets(days, costs)

        assert(expected === actual)
      }
    }
  }
}
