package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinimumCostToMergeStonesTest {
  private MinimumCostToMergeStones solution = new MinimumCostToMergeStones();

  @Test
  public void testLeetCodeExample1() {
    int[] stones = { 3, 2, 4, 1 };
    int k = 2;
    int expected = 20;
    int actual = solution.mergeStones(stones, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int[] stones = { 3, 2, 4, 1 };
    int k = 3;
    int expected = -1;
    int actual = solution.mergeStones(stones, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample3() {
    int[] stones = { 3, 5, 1, 2, 6 };
    int k = 3;
    int expected = 25;
    int actual = solution.mergeStones(stones, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetTestCase28() {
    int[] stones = { 1 };
    int k = 2;
    int expected = 0;
    int actual = solution.mergeStones(stones, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetTestCase29() {
    int[] stones = { 69, 39, 79, 78, 16, 6, 36, 97, 79, 27, 14, 31, 4 };
    int k = 2;
    int expected = 1957;
    int actual = solution.mergeStones(stones, k);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetTestCase53() {
    int[] stones = {
      16, 43, 87, 30, 4, 98, 12, 30, 47, 45, 32, 4, 64, 14, 24, 84, 86, 51, 11, 22, 4
    };
    int k = 2;
    int expected = 3334;
    int actual = solution.mergeStones(stones, k);

    assertEquals(expected, actual);
  }

  /*
  @Test
  public void testLeetTestCase58() {
    int[] stones = {
      46,
      96,
      43,
      76,
      38,
      38,
      51,
      86,
      5,
      19,
      30,
      73,
      66,
      2,
      55,
      23,
      32,
      13,
      86,
      100,
      95,
      24,
      17,
      40,
      14
    };
    int k = 2;
    int expected = 3334;
    int actual = solution.mergeStones(stones, k);

    assertEquals(expected, actual);
  }
  */
}
