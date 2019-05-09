package co.aa8y.leetcode;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.stream.IntStream;

/**
 * 55. Jump Game
 *
 * <p>Given an array of non-negative integers, you are initially positioned at the first index of
 * the array.
 *
 * <p>Each element in the array represents your maximum jump length at that position. Determine if
 * you are able to reach the last index.
 *
 * <p>Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * <p>Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
*/
public class JumpGame {
  Boolean[] cache;

  /**
   * Determines if we can jump and reach the last index from the first index.
   *
   * @param nums Array where each index defines the maximum steps from that index
   * @return true if possible, else false
   */
  public boolean canJump(int[] nums) {
    if (nums.length == 0) {
      return true;
    }
    cache = new Boolean[nums.length];

    return canJump(nums, 0);
  }

  private Boolean canJump(int[] nums, int fromIndex) {
    if (fromIndex >= nums.length) {
      return FALSE;
    }
    if (fromIndex == nums.length - 1) {
      return TRUE;
    }
    Boolean jump = cache[fromIndex];

    if (jump != null) {
      return jump;
    }
    jump = IntStream.range(0, nums[fromIndex] + 1)
                    .mapToObj(steps -> canJump(nums, fromIndex, steps))
                    .reduce(FALSE, (l, r) -> l || r);
    cache[fromIndex] = jump;

    return jump;
  }

  private Boolean canJump(int[] nums, int fromIndex, int steps) {
    int hops = fromIndex + steps;

    if (steps == 0 || hops >= nums.length) {
      return FALSE;
    }
    return canJump(nums, hops);
  }
}
