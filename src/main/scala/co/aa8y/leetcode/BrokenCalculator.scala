package co.aa8y.leetcode;

import scala.annotation.tailrec

/**
 * 991. Broken Calculator
 *
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 * 
 * 1. Double: Multiply the number on the display by 2, or;
 * 2. Decrement: Subtract 1 from the number on the display.
 *
 * Initially, the calculator is displaying the number X.
 * 
 * Return the minimum number of operations needed to display the number Y.
 * 
 * Example 1:
 * Input: X = 2, Y = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 *
 * Example 2:
 * Input: X = 5, Y = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 *
 * Example 3:
 * Input: X = 3, Y = 10
 * Output: 3
 * Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 *
 * Example 4:
 * Input: X = 1024, Y = 1
 * Output: 1023
 * Explanation: Use decrement operations 1023 times.
 * 
 * Note:
 * 1. 1 <= X <= 10^9
 * 2. 1 <= Y <= 10^9
 */
object BrokenCalculator {
  def brokenCalc(x: Int, y: Int): Int = {
    @tailrec
    def loop(y: Int, steps: Int): Int = {
      if (y == x) steps
      else if (y > x) {
        if (isOdd(y)) {
          loop((y / 2) + 1, steps + 2)
        } else {
          loop(y / 2, steps + 1)
        }
      } else loop(y + 1, steps + 1)
    }
    loop(y, 0)
  }

  def isOdd(n: Int): Boolean = {
    n % 2 == 1
  }
}
