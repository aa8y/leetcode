package co.aa8y.leetcode

import org.scalatest.{FunSpec, Ignore}

@Ignore
class PrefixAndSuffixSearchSpec extends FunSpec with ResourceHelper {
  describe("Problem 745: Prefix and Suffix Search") {
    describe("WordFilter.f()") {
      val words = Array("ducking", "dancing", "driving", "catching", "arrival")
      val wordFilter = new WordFilter(words)
      val prefix = "d"
      val suffix = "ing"

      it("should return -1 if no word with the prefix and suffix is found.") {
        val words = Array("foo", "bar", "baz")
        val wordFilter = new WordFilter(words)

        assert(wordFilter.f(prefix, suffix) === -1)
      }
      it("should retrun the word with the maxinum weight.") {
        assert(wordFilter.f(prefix, suffix) === 2)
      }
      it("should allow empty strings for prefix and suffix.") {
        assert(wordFilter.f("", suffix) === 3)
        assert(wordFilter.f(prefix, "") === 2)
        assert(wordFilter.f("", "") === 4)
      }
    }
    describe("LeetCode") {
      it("Test case #7") {
        val wordFilter = new WordFilter(Array("pop"))
        val computed = Seq(
          ("", ""),
          ("", "p"),
          ("", "op"),
          ("", "pop"),
          ("p", ""),
          ("p", "p"),
          ("p", "op"),
          ("p", "pop"),
          ("po", ""),
          ("po", "p"),
          ("po", "op"),
          ("po", "pop"),
          ("pop", ""),
          ("pop", "p"),
          ("pop", "op"),
          ("pop", "pop"),
          ("", ""),
          ("", "p"),
          ("", "gp"),
          ("", "pgp"),
          ("p", ""),
          ("p", "p"),
          ("p", "gp"),
          ("p", "pgp"),
          ("pg", ""),
          ("pg", "p"),
          ("pg", "gp"),
          ("pg", "pgp"),
          ("pgp", ""),
          ("pgp", "p"),
          ("pgp", "gp"),
          ("pgp", "pgp")
        ).map { case (prefix, suffix) => wordFilter.f(prefix, suffix) }
        val expected = Seq(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1)

        assert(computed === expected)
      }
      it("Test case #9") {
        val words = read("words.txt")
        val wordFilter = new WordFilter(words)
        val prefixes = read("prefixes.txt")
        val suffixes = read("suffixes.txt")

        val computed = prefixes.zip(suffixes).map { case (prefix, suffix) => wordFilter.f(prefix, suffix) }
        val expected = read("weights.txt").map(_.toInt).toSeq

        assert(computed.sameElements(expected))
      }
    }
  }
}
