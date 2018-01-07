package co.aa8y.leetcode

import scala.collection.mutable.Map

/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'S' for 'Start' in the diagram
 * below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'F' for 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * ---------------
 * |S| | | | | | |
 * ---------------
 * | | | | | | | |
 * ---------------
 * | | | | | | |F|
 * ---------------
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 */
object UniquePaths {
  def uniquePaths(m: Int, n: Int): Int = {
    val cache = Map[(Int, Int), Int]()

    def loop(m: Int, n: Int): Int = {
      if (m == 1 || n == 1) 1
      else {
        val k = (m, n)
        cache.get(k).getOrElse {
          val v = loop(m, n - 1) + loop(m - 1, n)
          cache.put(k, v)
          v
        }
      }
    }
    loop(m, n)
  }
}
