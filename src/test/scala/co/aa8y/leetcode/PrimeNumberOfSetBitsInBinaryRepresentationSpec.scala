package co.aa8y.leetcode

import org.scalatest.FunSpec

class PrimeNumberOfSetBitsInBinaryRepresentationSpec extends FunSpec {
  describe("762. Prime Number of Set Bits in Binary Representation") {
    import PrimeNumberOfSetBitsInBinaryRepresentation._

    describe("LeetCode") {
      it("Example #1") {
        val computed = countPrimeSetBits(6, 10)
        assert(computed === 4)
      }
      it("Example #2") {
        val computed = countPrimeSetBits(10, 15)
        assert(computed === 5)
      }
    }
  }
}
