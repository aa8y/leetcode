package co.aa8y.leetcode;

/**
 * 70. Climbing Stairs
 *
 * <p>You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the 
 * top?
 * 
 * <p>Note: Given n will be a positive integer.
 * 
 * <p>Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * <p>Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
*/
public class ClimbingStairs {
  private int[] cache = null;

  /**
   * Determines the number of ways n steps can be climbed if the number of steps one can take at a
   * time are either 1 or 2.
   *
   * @param n Number of steps to climb
   * @return Number of unique ways the steps can be climbed
   */
  public int climbStairs(int n) {
    if (cache == null) {
      cache = new int[n + 1];
    }
    if (n <= 2) {
      return n;
    } else if (cache[n] != 0) {
      return cache[n];
    } else {
      int l = climbStairs(n - 1);
      cache[n - 1] = l;
      int r = climbStairs(n - 2);
      cache[n - 2] = r;

      return l + r;
    }
  }
}
