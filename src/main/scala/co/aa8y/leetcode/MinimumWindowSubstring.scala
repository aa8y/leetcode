package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 *
 * Example:
 *   Input: S = "ADOBECODEBANC", T = "ABC"
 *   Output: "BANC"
 * Note:
 * 1. If there is no such window in S that covers all characters in T, return the empty string "".
 * 2. If there is such window, you are guaranteed that there will always be only one unique minimum
 * window in S.
 */
object MinimumWindowSubstring {
  trait State
  object Drop extends State
  object Ignore extends State

  def minWindow(s: String, t: String): String = {
    @tailrec
    def loop(acc: StringBuilder, mw: String, state: State, ss: List[Char], ts: List[Char]): String = {
      def getMinMw = {
        if (ts.nonEmpty) mw
        else if (mw.isEmpty || mw.size > acc.size) acc.toString
        else mw
      }

      ss match {
        case Nil => getMinMw
        case head :: tail =>
          if (ts.isEmpty) {
            loop(new StringBuilder(""), getMinMw, Drop, ss, t.toList)
          } else if (t.contains(head)) {
            loop(acc.append(head), mw, Ignore, tail, remove(head, ts))
          } else state match {
            case Ignore => loop(acc.append(head), mw, state, tail, ts)
            case Drop => loop(acc, mw, state, tail, ts)
          }
      }
    }
    loop(new StringBuilder(""), "", Drop, s.toList, t.toList)
  }

  def remove(c: Char, cs: List[Char]): List[Char] = cs.diff(c :: Nil)
}
