package co.aa8y.leetcode;

/**
 * 191. Number of 1 Bits
 *
 * <p>Write a function that takes an unsigned integer and return the number of '1' bits it has (also
 * known as the Hamming weight).
 *
 * <p>Example 1:
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1'
 * bits.
 *
 * <p>Example 2:
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 *
 * <p>Example 3:
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one
 * '1' bits.
 *
 * <p>Note:
 * 1. Note that in some languages such as Java, there is no unsigned integer type. In this case,
 * the input will be given as signed integer type and should not affect your implementation, as the
 * internal binary representation of the integer is the same whether it is signed or unsigned.
 * 2. In Java, the compiler represents the signed integers using 2's complement notation. Therefore,
 * in Example 3 above the input represents the signed integer -3.
 *
 * <p>Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class NumberOf1BitsIterative {
  /**
   * Returns the number of bits set in the given integer.
   *
   * @param n Integer with set bits
   * @return Number of bits set
   */
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >>> 1;
    }
    return count;
  }
}
