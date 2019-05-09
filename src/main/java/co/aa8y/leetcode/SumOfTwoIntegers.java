package co.aa8y.leetcode;

/**
 * 371. Sum of Two Integers
 *
 * <p>Calculate the sum of two integers a and b, without the operators + and -.
 *
 * <p>Example 1:
 * Input: a = 1, b = 2
 * Output: 3
 *
 * <p>Example 2:
 * Input: a = -2, b = 3
 * Output: 1
 */
public class SumOfTwoIntegers {
  /**
   * Calculates the sum of the two integers using bit manipulation.
   *
   * @param a Left integer
   * @param b Right integer
   * @return Sum of both the integers
   */
  public int getSum(int a, int b) {
    return getSum(a, b, 1, 0, 0);
  }

  private int getSum(int a, int b, int mask, int carry, int acc) {
    if (mask == 0) {
      return acc;
    }
    int ai = a & mask;
    int bi = b & mask;

    return getSum(a,
                  b,
                  mask << 1,
                  getCarry(ai, bi, carry) << 1,
                  acc | ((ai ^ bi) ^ carry));
  }

  private int getCarry(int ai, int bi, int oldCarry) {
    int carry = ai & bi;

    if (carry == 0) {
      carry = ai & oldCarry;
    }
    if (carry == 0) {
      carry = bi & oldCarry;
    }
    return carry;
  }
}
