package co.aa8y.leetcode

import scala.annotation.tailrec
import scala.math.pow

/**
 * 970. Powerful Integers
 * Given two non-negative integers x and y, an integer is powerful if it is equal to x^i + y^j for
 * some integers i >= 0 and j >= 0.
 * 
 * Return a list of all powerful integers that have value less than or equal to bound. You may
 * return the answer in any order. In your answer, each value should occur at most once.
 * 
 * Example 1:
 *   Input: x = 2, y = 3, bound = 10
 *   Output: [2, 3, 4, 5, 7, 9, 10]
 *   Explanation:
 *     2 = 2^0 + 3^0
 *     3 = 2^1 + 3^0
 *     4 = 2^0 + 3^1
 *     5 = 2^1 + 3^1
 *     7 = 2^2 + 3^1
 *     9 = 2^3 + 3^0
 *     10 = 2^0 + 3^2
 *
 * Example 2:
 *   Input: x = 3, y = 5, bound = 15
 *   Output: [2, 4, 6, 8, 10, 14]
 * 
 * Note:
 *   1. 1 <= x <= 100
 *   2. 1 <= y <= 100
 *   3. 0 <= bound <= 10^6
 */
object PowerfulIntegers {
  private val MaxI = 100

  def powerfulIntegers(x: Int, y: Int, bound: Int): List[Int] = {
    lazy val powerfulLeft = buildPowerfulHalf(x, bound)
    lazy val powerfulRight = buildPowerfulHalf(y, bound)

    @tailrec
    def loop(l: List[Int], r: List[Int], acc: List[Int]): List[Int] = {
      if (l.isEmpty) acc
      else r match {
        case rhead :: rtail =>
          val powerful = l.head + rhead
          if (powerful <= bound) loop(l, rtail, powerful :: acc)
          else loop(l, rtail, acc)
        case Nil => loop(l.tail, powerfulRight, acc)
      }
    }
    if (bound < 2) Nil else loop(powerfulLeft, powerfulRight, Nil).toSet.toList
  }

  def buildPowerfulHalf(n: Int, bound: Int): List[Int] = {
    @tailrec
    def loop(i: Int, acc: List[Int]): List[Int] = {
      if (i > MaxI) acc
      else {
        val powerfulHalf = pow(n, i).toInt
        if (powerfulHalf >= bound) acc
        else loop(i + 1, powerfulHalf :: acc)
      }
    }
    loop(0, Nil)
  }
}
