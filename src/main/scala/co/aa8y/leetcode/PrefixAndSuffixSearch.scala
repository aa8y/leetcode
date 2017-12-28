package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * Given many words, words[i] has weight i. Design a class WordFilter that supports one function,
 * WordFilter.f(String prefix, String suffix). It will return the word with given prefix and
 * suffix with maximum weight. If no word exists, return -1.
 *
 * Examples:
 *   Input:
 *     WordFilter(["apple"])
 *     WordFilter.f("a", "e") // returns 0
 *     WordFilter.f("b", "") // returns -1
 *
 * Note:
 * 1. words has length in range [1, 15000].
 * 2. For each test case, up to words.length queries WordFilter.f may be made.
 * 3. words[i] has length in range [1, 10].
 * 4. prefix, suffix have lengths in range [0, 10].
 * 5. words[i] and prefix, suffix queries consist of lowercase letters only.
 */
class WordFilter(words: Array[String]) {
  lazy val prefixCache = buildCache((s: String) => (i: Int) => s.take(i))
  lazy val suffixCache = buildCache((s: String) => (i: Int) => s.takeRight(i))

  /**
   * Takes as a parameter, a function takes in a string and an index and returns a substring.
   */
  private def buildCache(buildKey: String => Int => String) = {
    words.zipWithIndex.foldLeft(Map[String, List[Int]]()) { (cache, next) =>
      val (word, weight) = next

      (0 to word.size).foldLeft(cache) { (localCache, i) =>
        val k = buildKey(word)(i)
        val w = localCache.get(k) match {
          case Some(weights) => weight :: weights
          case _ => weight :: Nil
        }
        localCache.updated(k, w)
      }
    }
  }

  def f(prefix: String, suffix: String): Int = {
    @tailrec
    def loop(l: List[Int], r: List[Int]): Int = {
      if (l.isEmpty || r.isEmpty) -1
      else if (l.head > r.head) loop(l.tail, r)
      else if (l.head < r.head) loop(l, r.tail)
      else l.head
    }
    prefixCache.get(prefix) match {
      case Some(pw) => suffixCache.get(suffix) match {
        case Some(sw) => loop(pw, sw)
        case _ => -1
      }
      case _ => -1
    }
  }
}
