package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TwoSumTest {
  private TwoSumBruteForce bruteForceSolution = new TwoSumBruteForce();
  private TwoSumLinearTime linearTimeSolution = new TwoSumLinearTime();

  @Test
  public void testLeetCodeExample1() {
    int[] nums = { 2, 7, 11, 15 };
    int target = 9;
    int[] expected = { 0, 1 };
    int[] actualBruteForce = bruteForceSolution.twoSum(nums, target); 
    int[] actualLinearTime = linearTimeSolution.twoSum(nums, target); 

    assertArrayEquals(expected, actualBruteForce);
    assertArrayEquals(expected, actualLinearTime);
  }

  @Test
  public void testLeetCustom1() {
    int[] nums = { 2, 11, 15, 7 };
    int target = 9;
    int[] expected = { 0, 3 };
    int[] actualBruteForce = bruteForceSolution.twoSum(nums, target); 
    int[] actualLinearTime = linearTimeSolution.twoSum(nums, target); 

    assertArrayEquals(expected, actualBruteForce);
    assertArrayEquals(expected, actualLinearTime);
  }

  @Test
  public void testLeetCustom2() {
    int[] nums = { 2, 1, 3, 7 };
    int target = 9;
    int[] expected = { 0, 3 };
    int[] actualBruteForce = bruteForceSolution.twoSum(nums, target); 
    int[] actualLinearTime = linearTimeSolution.twoSum(nums, target); 

    assertArrayEquals(expected, actualBruteForce);
    assertArrayEquals(expected, actualLinearTime);
  }
}
