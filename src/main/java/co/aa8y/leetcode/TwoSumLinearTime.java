package co.aa8y.leetcode;

import java.util.HashMap;
import java.util.Map;

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
public class TwoSumLinearTime {
  private Map<Integer, Integer> lookup = new HashMap<>();

  /**
   * Given an array of integers and a target, finds the indices of the two integers which sum up
   * to the target.
   *
   * @param nums Array of integers
   * @param target Target integer
   * @return Indices of the integers which sum up to the target
   */
  public int[] twoSum(int[] nums, int target) {
    Integer boxedTarget = Integer.valueOf(target);

    for (int i = 0; i < nums.length; i++) {
      // Here assuming, target = left + right
      Integer left = nums[i];
      // if the lookup contains the left value
      if (lookup.containsKey(left)) {
        // then the current left value is really the right value for the left value in the lookup
        return new int[] { lookup.get(left).intValue(), i };
      } else {
        // If the left value is not found, compute the right value
        Integer right = boxedTarget - left;
        // and store the index of the left value it corresponds to for future lookup
        lookup.put(right, Integer.valueOf(i));
      }
    }
    return null;
  }
}
