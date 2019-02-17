package co.aa8y.leetcode;

/**
 * 1. Two Sum
 *
 * <p>Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.
 *
 * <p>You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * <p>Example:
 * Given,
 *   nums = [2, 7, 11, 15],
 *   target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSumBruteForce {
  /**
   * Given an array of integers and a target, finds the indices of the two integers which sum up
   * to the target.
   *
   * @param nums Array of integers
   * @param target Target integer
   * @return Indices of the integers which sum up to the target
   */
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] { i, j };
        }
      }
    }
    return null;
  }
}
