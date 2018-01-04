package co.aa8y.leetcode

import org.scalatest.FunSpec

class UniquePathsSpec extends FunSpec {
  describe("Problem 062: Unique Paths") {
    import UniquePaths._

    describe("uniquePaths()") {
      it("should return 1 for grids with a single row or column.") {
        assert(uniquePaths(1, 59) === 1)
        assert(uniquePaths(23, 1) === 1)
      }
    }
    describe("LeetCode") {
      it("Test case #1") {
        assert(uniquePaths(1, 2) === 1)
      }
      it("Test case #43") {
        assert(uniquePaths(13, 23) === 548354040)
      }
    }
  }
}
