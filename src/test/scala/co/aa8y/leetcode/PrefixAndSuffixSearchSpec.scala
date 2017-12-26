package co.aa8y.leetcode

import org.scalatest.FunSpec

class PrefixAndSuffixSearchSpec extends FunSpec {
  describe("Problem 745: Prefix and Suffix Search") {
    describe("WordFilter.f()") {
      val prefix = "d"
      val suffix = "ing"

      it("should return -1 if no word with the prefix and suffix is found.") {
        val words = Array("foo", "bar", "baz")
        val wordFilter = new WordFilter(words)

        assert(wordFilter.f(prefix, suffix) === -1)
      }
      it("should retrun the word with the maxinum weight.") {
        val words = Array("ducking", "dancing", "driving")
        val wordFilter = new WordFilter(words)

        assert(wordFilter.f(prefix, suffix) === 2)
      }
    }
  }
}
