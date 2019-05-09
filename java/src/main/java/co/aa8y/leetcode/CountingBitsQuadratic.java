package co.aa8y.leetcode;

/**
 * 338. Counting Bits
 *
 * <p>Given a non negative integer number num. For every numbers {@code i} in the range
 * {@code 0 <= i <= num} calculate the number of 1's in their binary representation and return them
 * as an array.
 *
 * <p>Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * <p>Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * <p>Follow up:
 * 1. It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do
 * it in linear time O(n), possibly in a single pass?
 * 2. Space complexity should be O(n).
 * 3. Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in
 * c++ or in any other language.
 */
public class CountingBitsQuadratic {
  /**
   * Counts the number of bits in all the integers less than and equal to the given number.
   *
   * @param num {@code 0 <= n <= num}
   * @return Counts for {@code n}
   */
  public int[] countBits(int num) {
    int[] counts = new int[num + 1];

    for (int i = 0; i <= num; i++) {
      counts[i] = hammingWeight(i);
    }

    return counts;
  }

  private int hammingWeight(int n) {
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
