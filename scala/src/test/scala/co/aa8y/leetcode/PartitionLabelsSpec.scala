package co.aa8y.leetcode

import org.scalatest.FunSpec

class PartitionLabelsSpec extends FunSpec {
  describe("763. Partition Labels") {
    import PartitionLabels._

    describe("LeetCode") {
      it("Example #1") {
        val s = "ababcbacadefegdehijhklij"
        val expected = List(9, 7, 8)
        val computed = partitionLabels(s)

        assert(computed === expected)
      }
    }
  }
}
