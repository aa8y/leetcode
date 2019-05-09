package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClimbingStairsTest {
  ClimbingStairs solution = new ClimbingStairs();

  @Test
  public void testLeetCodeExample1() {
    int expected = 2;
    int actual = solution.climbStairs(2);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int expected = 3;
    int actual = solution.climbStairs(3);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1() {
    int expected = 5;
    int actual = solution.climbStairs(4);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom5() {
    int expected = 8;
    int actual = solution.climbStairs(5);

    assertEquals(expected, actual);
  }
}
