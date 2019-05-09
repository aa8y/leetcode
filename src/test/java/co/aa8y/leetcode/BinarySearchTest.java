package co.aa8y.leetcode;

import static co.aa8y.leetcode.testutils.FileUtil.readLinesAsIntArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {
  private BinarySearch solution = new BinarySearch();

  @Test
  public void testLeetCodeExample1() {
    int[] nums = { -1, 0, 3, 5, 9, 12 };
    int target = 9;
    int expected = 4;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int[] nums = { -1, 0, 3, 5, 9, 12 };
    int target = 2;
    int expected = -1;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCaseX() {
    int[] nums = { -1, 0, 3, 5, 9, 12 };
    int target = 13;
    int expected = -1;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase30() {
    int[] nums = { 2, 5 };
    int target = 5;
    int expected = 1;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase3X() {
    int[] nums = { 2, 5 };
    int target = 0;
    int expected = -1;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase44() {
    int[] nums = readLinesAsIntArray("/704_BinarySearch_LeetCodeTestCase44.txt");
    int target = 6721;
    int expected = 8421;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1() {
    int[] nums = { };
    int target = 1;
    int expected = -1;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom2() {
    int[] nums = { 10 };
    int target = 1;
    int expected = -1;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom3() {
    int[] nums = { 10 };
    int target = 10;
    int expected = 0;
    int actual = solution.search(nums, target);

    assertEquals(expected, actual);
  }
}
