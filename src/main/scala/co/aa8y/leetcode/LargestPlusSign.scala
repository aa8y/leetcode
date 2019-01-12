package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * 764. Largest Plus Sign
 *
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given
 * list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid?
 * Return the order of the plus sign. If there is none, return 0.
 *
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of
 * length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams
 * below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area
 * of the plus sign is checked for 1s.
 *
 * Examples of Axis-Aligned Plus Signs of Order k:
 *
 * Order 1:
 * 000
 * 010
 * 000
 *
 * Order 2:
 * 00000
 * 00100
 * 01110
 * 00100
 * 00000
 *
 * Order 3:
 * 0000000
 * 0001000
 * 0001000
 * 0111110
 * 0001000
 * 0001000
 * 0000000
 *
 * Example 1:
 *   Input: N = 5, mines = [[4, 2]]
 *   Output: 2
 *   Explanation:
 *     11111
 *     11111
 *     11111
 *     11111
 *     11011
 *   In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
 *
 * Example 2:
 *   Input: N = 2, mines = []
 *   Output: 1
 *   Explanation: There is no plus sign of order 2, but there is of order 1.
 *
 * Example 3:
 *   Input: N = 1, mines = [[0, 0]]
 *   Output: 0
 *   Explanation: There is no plus sign, so return 0.
 *
 * Note:
 * 1. N will be an integer in the range [1, 500].
 * 2. mines will have length at most 5000.
 * 3. mines[i] will be length 2 and consist of integers in the range [0, N-1].
 */
object LargestPlusSign {
  def orderOfLargestPlusSign(n: Int, mines: Array[Array[Int]]): Int = {
    @tailrec
    def loop(n: Int, mines: Array[Array[Int]], x: Int, y: Int): Int = {
      if (x == 0 && y == 0) {
        if (mines.size == 1) 0
        else if (n % 2 == 0) (n / 2)
        else (n / 2) + 1
      } else if (hasDiagonalMines(mines)) {
        loop(n / 2, Array.empty[Array[Int]], 0, 0)
      } else {
        val mx = mines.filter(_(0) != x)
        val my = mx.filter(_(1) != y)

        if (mines.size - mx.size > 0 || mines.size - my.size > 0) loop(n - 1, my, x - 1, y - 1)
        else loop(n, my, x - 1, y - 1)
      }
    }
    if (n == 0) 0 else loop(n, mines, n - 1, n - 1)
  }

  def hasDiagonalMines(mines: Array[Array[Int]]): Boolean = {
    @tailrec
    def loop(p: Int, q: Int): Boolean = {
      if (q == mines.size) true
      else {
        val Array(px, py) = mines(p)
        val Array(qx, qy) = mines(q)
        if (qx - px == 1 && qy - py == 1) loop(p + 1, q + 1) else false
      }
    }
    if (mines.size > 1) loop(0, 1) else false
  }
}
