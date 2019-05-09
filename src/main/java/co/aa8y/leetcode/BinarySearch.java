package co.aa8y.leetcode;

/**
 * 704. Binary Search
 *
 * <p>Given a sorted (in ascending order) integer array nums of n elements and a target value, 
 * write a function to search target in nums. If target exists, then return its index, otherwise 
 * return -1.
 * 
 * <p>Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 
 * <p>Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * 
 * <p>Note:
 * 1. You may assume that all elements in nums are unique.
 * 2. n will be in the range [1, 10000].
 * 3. The value of each element in nums will be in the range [-9999, 9999].
 */
public class BinarySearch {
  /**
   * Searchs for the {@code target} in the given array and returns the index if present.
   *
   * @param nums Array to search in
   * @param target Target to search for
   * @return Index of the target if present, otherwise -1
   */
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    return search(nums, target, 0, nums.length - 1);
  }

  private int search(int[] nums, int target, int start, int end) {
    int i = (start + end) / 2;

    // When only one element is left, start == end
    if (start == end && target != nums[i] || start > end) {
      return -1;
    }
    if (target > nums[i]) {
      return search(nums, target, i + 1, end);
    } else if (target < nums[i]) {
      return search(nums, target, start, i - 1);
    } else {
      return i;
    }
  }
}
