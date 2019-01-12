package co.aa8y.leetcode

import org.scalatest.FunSpec

class ReorderLogFilesSpec extends FunSpec {
  describe("937. Reorder Log Files") {
    import ReorderLogFiles._

    describe("reorderLogFiles()") {
      describe("LeetCode") {
        it("Example #1") {
          val input = Array(
            "a1 9 2 3 1",
            "g1 act car",
            "zo4 4 7",
            "ab1 off key dog",
            "a8 act zoo"
          )
          val expected = Array(
            "g1 act car",
            "a8 act zoo",
            "ab1 off key dog",
            "a1 9 2 3 1",
            "zo4 4 7"
          )
          val actual = reorderLogFiles(input)
          assert(expected === actual)
        }
      }
    }
  }
}
