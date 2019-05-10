package co.aa8y.leetcode

import org.scalatest.{FunSpec, Ignore}

@Ignore
class StampingTheSequenceSpec extends FunSpec {
  describe("936. Stamping The Sequence") {
    import StampingTheSequence._

    describe("movesToStamp()") {
      it("1") {
        assert(movesToStamp("abc", "ababc") === Array(0, 2))
      }
      it("2") {
        assert(movesToStamp("abca", "aabcaca") === Array(3, 0, 1))
      }
    }
  }
}
