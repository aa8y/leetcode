package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * 749. Shortest Completing Word
 *
 * Find the minimum length word from a given dictionary `words`, which has all the letters from the
 * string `licensePlate`. Such a word is said to complete the given string `licensePlate`.
 *
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the
 * word.
 *
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs 
 * first in the array.
 *
 * The license plate might have the same letter occurring multiple times. For example, given a 
 * `licensePlate` of "PP", the word "pair" does not complete the `licensePlate`, but the word 
 * "supper" does.
 *
 * Example 1:
 *   Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 *   Output: "steps"
 *   Explanation: The smallest length word that contains the letters "S", "P", "S", and "T". Note 
 *   that the answer is not "step", because the letter "s" must occur in the word twice. Also note 
 *   that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 *   Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 *   Output: "pest"
 *   Explanation: There are 3 smallest length words that contains the letters "s". We return the 
 *   one that occurred first.
 *
 * Note:
 * 1. `licensePlate` will be a string with length in range [1, 7].
 * 2. `licensePlate` will contain digits, spaces, or letters (uppercase or lowercase).
 * 3. `words` will have a length in the range [10, 1000].
 * 4. Every `words[i]` will consist of lowercase letters, and have length in range [1, 15].
 */
object ShortestCompletingWord {
  def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
    @tailrec
    def loop(license: Map[Char, Int], i: Int, acc: List[String]): String = {
      if (i < 0) acc.head
      else {
        val word = words(i)
        if (isComplete(license, getLetterFreq(word))) {
          val newAcc = acc match {
            case Nil => word :: Nil
            case _ =>
              val wordSize = word.size
              val prevSize = acc.head.size

              if (wordSize == prevSize) word :: acc
              else if (wordSize > prevSize) acc
              else word :: Nil
          }
          loop(license, i - 1, newAcc)
        } else {
          loop(license, i - 1, acc)
        }
      }
    }
    val license = getLetterFreq(licensePlate)
    loop(license, words.size - 1, Nil)
  }
  /**
   * Returns the frequency of the letters in a given string. If the string is not a true word, i. e.
   * it contains non-alphabetical characters, the function filters them out.
   */
  def getLetterFreq(word: String): Map[Char, Int] = {
    word.toLowerCase.foldLeft(Map[Char, Int]()) { (acc, c) =>
      if (c >= 'a' && c <= 'z') {
        val count = acc.get(c).map(_ + 1).getOrElse(1)
        acc.updated(c, count)
      } else acc
    }
  }
  /**
   * Given two letter frequencies, one for the license and one for the word, the function determines
   * if the word completes the license, i. e., all the letters in the license occur in the word.
   */
  def isComplete(license: Map[Char, Int], word: Map[Char, Int]): Boolean = {
    @tailrec
    def loop(license: List[(Char, Int)]): Boolean = {
      if (license.isEmpty) true
      else {
        val (c, count) = license.head
        word.get(c) match {
          case Some(wordCount) if (wordCount >= count) => loop(license.tail)
          case _ => false
        }
      }
    }
    loop(license.toList)
  }
}
