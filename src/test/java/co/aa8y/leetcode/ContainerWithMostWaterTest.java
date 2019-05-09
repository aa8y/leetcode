package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ContainerWithMostWaterTest {
  private ContainerWithMostWater solution = new ContainerWithMostWater();

  @Test
  public void testLeetCodeExample1() {
    int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    int expected = 49;
    int actual = solution.maxArea(height);

    assertEquals(expected, actual);
  }
}
