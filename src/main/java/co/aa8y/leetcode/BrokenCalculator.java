package co.aa8y.leetcode;

/**
 * 991. Broken Calculator
 *
 * <p>On a broken calculator that has a number showing on its display, we can perform two 
 * operations:
 * 1. Double: Multiply the number on the display by 2, or;
 * 2. Decrement: Subtract 1 from the number on the display.
 *
 * <p>Initially, the calculator is displaying the number X.
 * 
 * <p>Return the minimum number of operations needed to display the number Y.
 * 
 * <p>Example 1:
 * Input: X = 2, Y = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {@code 2 -> 4 -> 3}.
 *
 * <p>Example 2:
 * Input: X = 5, Y = 8
 * Output: 2
 * Explanation: Use decrement and then double {@code 5 -> 4 -> 8}.
 *
 * <p>Example 3:
 * Input: X = 3, Y = 10
 * Output: 3
 * Explanation:  Use double, decrement and double {@code 3 -> 6 -> 5 -> 10}.
 *
 * <p>Example 4:
 * Input: X = 1024, Y = 1
 * Output: 1023
 * Explanation: Use decrement operations 1023 times.
 * 
 * <p>Note:
 * 1. {@code 1 <= X <= 10^9}
 * 2. {@code 1 <= Y <= 10^9}
 */
public class BrokenCalculator {
  /**
   * Determines the number of steps required to convert x to y if the only operations that can be
   * performed on x are either multiplication by 2 or subtraction by 1.
   *
   * @param x Number to be converted from
   * @param y Number to be converted to
   * @return Number of steps required for the convertion
   */
  public int brokenCalc(int x, int y) {
    return calcSteps(x, y);
  }

  private int calcSteps(int x, int y) {
    int steps = 0;
    for (steps = 0; x != y; steps++) {
      if (y > x) {
        if (isOdd(y)) {
          steps++;
          y = (y / 2) + 1;
        } else {
          y = y / 2;
        }
      } else if (y < x) {
        y = y + 1;
      }
    }
    return steps;
  }

  private boolean isOdd(int n) {
    return n % 2 == 1;
  }
}
