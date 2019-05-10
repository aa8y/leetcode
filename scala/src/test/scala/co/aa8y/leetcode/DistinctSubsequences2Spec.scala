package co.aa8y.leetcode

import org.scalatest.{FunSpec, Ignore}
import org.scalatest.tagobjects.Slow

@Ignore
class DistinctSubsequences2Spec extends FunSpec {
  describe("940. Distinct Subsequences II") {
    import DistinctSubsequences2._

    describe("distinctSubseqII()") {
      describe("LeetCode") {
        it("Example #1") {
          val expected = 7
          val actual = distinctSubseqII("abc")

          assert(expected === actual)
        }
        it("Example #2") {
          val expected = 6
          val actual = distinctSubseqII("aba")

          assert(expected === actual)
        }
        it("Example #3") {
          val expected = 3
          val actual = distinctSubseqII("aaa")

          assert(expected === actual)
        }
        it("Test case #50", Slow) {
          val expected = 0
          val actual = distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve")

          assert(expected === actual)
        }
      }
    }
  }
}
