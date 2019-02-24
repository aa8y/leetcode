package co.aa8y.leetcode;

public class NumberOf1BitsIterative {
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
