package co.aa8y.leetcode

import scala.annotation.tailrec
import scala.collection.mutable.{Map => MutableMap}

/**
 * 940. Distinct Subsequences II
 *
 * Given a string S, count the number of distinct, non-empty subsequences of S.
 *
 * Since the result may be large, return the answer modulo 10^9 + 7.
 *
 * Example 1:
 * Input: "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 *
 * Example 2:
 * Input: "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
 *
 * Example 3:
 * Input: "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 *
 * Note:
 * 1. S contains only lowercase letters.
 * 2. 1 <= S.length <= 2000
 */
object DistinctSubsequences2 {
  private val cache = MutableMap[(String, Int), Seq[String]]()

  def distinctSubseqII(s: String): Int = {
    @tailrec
    def loop(s: String, size: Int, acc: Set[String]): Set[String] = {
      if (size == 0) acc
      else if (size == s.size) {
        loop(s, size - 1, acc + s)
      } else {
        loop(s, size - 1, acc ++ buildSubseq(s, size))
      }
    }
    loop(s, s.size, Set()).size
  }

  def buildSubseq(s: String, size: Int): Seq[String] = {
    cache.get(s, size).getOrElse {
      size match {
        case 0 => throw new IllegalArgumentException("Size cannot be 0.")
        case 1 => s.map(_.toString)
        case _ =>
          for {
            i <- (0 to s.size - size)
            sub <- {
              val str = s.substring(i + 1, s.size)
              val sz = size - 1
              val subsq = buildSubseq(str, sz)
              cache.update((str, sz), subsq)
              subsq
            }
          } yield {
            s.charAt(i) + sub
          }
      }
    }
  }
}
