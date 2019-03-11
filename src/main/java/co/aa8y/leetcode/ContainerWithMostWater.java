package co.aa8y.leetcode;

/**
 * 11. Container With Most Water
 *
 * <p>Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
 * (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and
 * (i, 0). Find two lines, which together with x-axis forms a container, such that the container
 * contains the most water.
 *
 * <p>Note: You may not slant the container and n is at least 2.
*/
public class ContainerWithMostWater {
  /**
   * Determines the biggest container created by the vertical lines drawn by the given heights.
   *
   * @param height Heights which form the container
   * @return Maximum area formed by the lines
   */
  public int maxArea(int[] height) {
    if (height.length == 0 || height.length == 1) {
      return 0;
    }
    int l = 0;
    int r = height.length - 1;
    int max = 0;

    while (l < r) {
      int h = Math.min(height[l], height[r]);
      int b = r - l;
      int area = h * b;

      max = max < area ? area : max;

      if (height[l] < height[r]) {
        l++;
      } else if (height[l] > height[r]) {
        r--;
      } else {
        l++;
        r--;
      }
    }

    return max;
  }
}
