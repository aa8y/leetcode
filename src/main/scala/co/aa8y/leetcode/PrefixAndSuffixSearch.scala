package co.aa8y.leetcode

import scala.annotation.tailrec

class WordFilter(words: Array[String]) {

  def f(prefix: String, suffix: String): Int = {
    @tailrec
    def loop(i: Int, maxWeight: Int): Int = {
      if (i == words.size) maxWeight
      else if (words(i).startsWith(prefix) && words(i).endsWith(suffix) && i > maxWeight) {
        loop(i + 1, i)
      } else loop(i + 1, maxWeight)
    }
    loop(0, -1)
  }
}
