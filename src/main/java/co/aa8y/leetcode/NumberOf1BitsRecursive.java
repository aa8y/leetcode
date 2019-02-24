package co.aa8y.leetcode;

public class NumberOf1BitsRecursive {
  public int hammingWeight(int n) {
    return hammingWeight(n, 0);
  }

  private int hammingWeight(int n, int count) {
    if (n == 0) {
      return count;
    }
    if ((n & 1) == 1) {
      return hammingWeight(n >>> 1, count + 1);
    }
    return hammingWeight(n >>> 1, count);
  }
}
