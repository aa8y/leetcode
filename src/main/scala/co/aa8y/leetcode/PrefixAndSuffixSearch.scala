package co.aa8y.leetcode

class WordFilter(words: Array[String]) {
  val cache = {
    val map = for {
      (word, i) <- words.zipWithIndex
      j <- 0 to word.size
      k <- 0 to word.size
    } yield {
      val prefix = word.take(j)
      val suffix = word.takeRight(k)
      val key = (prefix, suffix)

      (key -> i)
    }
    map.toMap
  }

  def f(prefix: String, suffix: String): Int = {
    cache.get(prefix, suffix).getOrElse(-1)
  }
}
