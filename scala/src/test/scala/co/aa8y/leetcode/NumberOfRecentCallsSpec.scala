package co.aa8y.leetcode

import org.scalatest.FunSpec

class NumberOfRecentCallsSpec extends FunSpec {
  describe("933. Number of Recent Calls") {
    import NumberOfRecentCalls._

    describe("RecentCounter") {
      it("should stop incrementing after a point if a pings are at equal bursts.") {
        val r = new RecentCounter()
        assert(r.ping(1500) === 1)
        assert(r.ping(3000) === 2)
        assert(r.ping(4500) === 3)
        assert(r.ping(6000) === 3)
        assert(r.ping(7500) === 3)
      }
    }
    describe("LeetCode") {
      it("Example #1") {
        val r = new RecentCounter()
        assert(r.ping(1) === 1)
        assert(r.ping(100) === 2)
        assert(r.ping(3001) === 3)
        assert(r.ping(3002) === 3)
      }
      it("Test case") {
        val r = new RecentCounter()
        assert(r.ping(1178) === 1)
        assert(r.ping(1483) === 2)
        assert(r.ping(1563) === 3)
        assert(r.ping(4054) === 4)
        assert(r.ping(4152) === 5)
      }
    }
  }
}
