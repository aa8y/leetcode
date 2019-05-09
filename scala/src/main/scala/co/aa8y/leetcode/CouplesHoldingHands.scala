package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * 765. Couples Holding Hands
 *
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum
 * number of swaps so that every couple is sitting side by side. A swap consists of choosing any
 * two people, then they stand up and switch seats.
 *
 * The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in
 * order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last
 * couple being (2N-2, 2N-1).
 *
 * The couples' initial seating is given by row[i] being the value of the person who is initially
 * sitting in the i-th seat.
 *
 * Example 1:
 *   Input: row = [0, 2, 1, 3]
 *   Output: 1
 *   Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
 *
 * Example 2:
 *   Input: row = [3, 2, 0, 1]
 *   Output: 0
 *   Explanation: All couples are already seated side by side.
 *
 * Note:
 * 1. len(row) is even and in the range of [4, 60].
 * 2. row is guaranteed to be a permutation of 0...len(row)-1.
 */
object CouplesHoldingHands {
  def minSwapsCouples(row: Array[Int]): Int = {
    @tailrec
    def loop(row: Array[Int], i: Int, swaps: Int): Int = {
      println(row.toList, i, swaps)
      val l = row(i)
      val r = row(i + 1)

      if (i == row.size) swaps
      else if (isEven(i)) {
        if (isCouple(l, r)) {
          loop(row, i + 2, swaps)
        } else if (l > r) {
          loop(swap(i, i + 1), i + 1, swaps + 1)
        } else {//if (l < r && r - l == 1) {
          loop(swap(i + 1, i + 2), i, swaps + 1)
        //} else {
        }
      } else {
        if (l < r) {
          loop(swap(i + 1, i + 2), i - 1, swaps + 1)
        } else {
          loop(swap(i + 1, i + 2), i, swaps + 1)
        }
      }
    }
    def swap(i: Int, j: Int): Array[Int] = {
      val tmp = row(i)
      row(i) = row(j)
      row(j) = tmp

      row
    }
    if (row.size == 0) 0 else loop(row, 0, 0)
  }

  def getCouple(n: Int): Int = {
    if (isEven(n)) n + 1 else n - 1
  }

  def isCouple(l: Int, r: Int): Boolean = {
    if (l < r) {
      r - l == 1 && isEven(l)
    } else {
      l - r == 1 && isEven(r)
    }
  }

  def isEven(n: Int): Boolean = n % 2 == 0
}
