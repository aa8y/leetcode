package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * 763. Partition Labels
 *
 * A string S of lowercase letters is given. We want to partition this string into as many parts as
 * possible so that each letter appears in at most one part, and return a list of integers
 * representing the size of these parts.
 *
 * Example 1:
 *   Input: S = "ababcbacadefegdehijhklij"
 *   Output: [9,7,8]
 *   Explanation:
 *     1. The partition is "ababcbaca", "defegde", "hijhklij".
 *     2. This is a partition so that each letter appears in at most one part.
 *     3. A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into
 *        less parts.
 * Note:
 *   1. S will have length in range [1, 500].
 *   2. S will consist of lowercase letters ('a' to 'z') only.
 */
object PartitionLabels {
  def partitionLabels(s: String): List[Int] = {
    def buildAcc(c: Char, acc: List[List[Char]]): List[List[Char]] = acc match {
      case Nil => (c :: Nil) :: Nil
      case _ =>
        val i = acc.indexWhere(_.contains(c))
        if (i == -1) (c :: Nil) :: acc else {
          val (l, r) = acc.splitAt(i + 1)
          (c :: l.reduce(_ ++ _)) :: r
        }
    }
    @tailrec
    def loop(chars: List[Char], acc: List[List[Char]]): List[List[Char]] = chars match {
      case Nil => acc
      case c :: cs => loop(cs, buildAcc(c, acc))
    }
    loop(s.toList, Nil).map(_.size).reverse
  }
}
