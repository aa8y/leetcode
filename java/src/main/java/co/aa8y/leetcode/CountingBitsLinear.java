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
public class CountingBitsLinear {
  /**
   * Uses the expected pattern of 1s to determine the number of 1s for a number rather than
   * computing it.
   *
   * @param num {@code 0 <= n <= num}
   * @return Counts for {@code n}
   */
  public int[] countBits(int num) {
    int[] counts = new int[num + 1];
    if (num == 0) {
      return counts;
    }
    counts[1] = 1;

    /**
     * |--------|--------|-------|
     * | Number | Binary | Count |
     * |--------|--------|-------|
     * |    0   | 000000 |   0   |
     * |    1   | 000001 |   1   |
     * |    2   | 000010 |   1   |
     * |    3   | 000011 |   2   |
     * |    4   | 000100 |   1   |
     * |    5   | 000101 |   2   |
     * |    6   | 000110 |   2   |
     * |    7   | 000111 |   3   |
     * |    8   | 001000 |   1   |
     * |    9   | 001001 |   2   |
     * |   10   | 001010 |   2   |
     * |   11   | 001011 |   2   |
     * |   12   | 001100 |   2   |
     * |   13   | 001101 |   3   |
     * |   14   | 001110 |   3   |
     * |   15   | 001111 |   4   |
     * |   16   | 010000 |   1   |
     * |--------|--------|-------|
     */
    for (int i = 0; i <= num; i++) {
      if (isOdd(i)) {
        counts[i] = counts[i >> 1] + 1;
      } else {
        counts[i] = counts[i >> 1];
      }
    }

    return counts;
  }

  private boolean isOdd(int n) {
    return (n & 1) == 1;
  }
}
