package co.aa8y.leetcode

import org.scalatest.{FunSpec, Ignore}
import org.scalatest.tagobjects.Slow

@Ignore
class CourseScheduleSpec extends FunSpec {
  describe("207. Course Schedule") {
    import CourseSchedule._

    describe("canFinish()") {
    }
    describe("LeetCode") {
      it("Example #1") {
        val expected = true
        val actual = canFinish(2, Array(Array(1, 0)))

        assert(expected === actual)
      }
      it("Example #2") {
        val expected = false
        val actual = canFinish(2, Array(Array(1, 0), Array(0, 1)))

        assert(expected === actual)
      }
      it("Test case #38", Slow) {
        val expected = true
        val actual = canFinish(3, Array(Array(0, 1), Array(0, 2), Array(1, 2)))

        assert(expected === actual)
      }
    }
  }
}
