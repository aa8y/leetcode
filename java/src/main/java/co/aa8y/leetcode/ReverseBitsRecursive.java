package co.aa8y.leetcode;

/**
 * 190. Reverse Bits
 *
 * <p>Reverse bits of a given 32 bits unsigned integer.
 *
 * <p>Example 1:
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned
 * integer 43261596, so return 964176192 which its binary representation is
 * 00111001011110000010100101000000.
 *
 * <p>Example 2:
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned
 * integer 4294967293, so return 3221225471 which its binary representation is
 * 10101111110010110010011101101001.
 *
 * <p>Note:
 * 1. Note that in some languages such as Java, there is no unsigned integer type. In this case,
 * both input and output will be given as signed integer type and should not affect your
 * implementation, as the internal binary representation of the integer is the same whether it is
 * signed or unsigned.
 * 2. In Java, the compiler represents the signed integers using 2's complement notation. Therefore,
 * in Example 2 above the input represents the signed integer -3 and the output represents the
 * signed integer -1073741825.
 *
 * <p>Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBitsRecursive {
  /**
   * Reverses the bits of a given integer.
   *
   * @param n Integer whose bits are to be reversed
   * @return Integer with bits reversed
   */
  public int reverseBits(int n) {
    return reverseBits(n, Integer.MIN_VALUE, 0);
  }

  private int reverseBits(int n, int mask, int acc) {
    if (n == 0) {
      return acc;
    }
    if ((n & 1) == 1) {
      return reverseBits(n >>> 1, mask >>> 1, acc | mask);
    }
    return reverseBits(n >>> 1, mask >>> 1, acc);
  }
}
