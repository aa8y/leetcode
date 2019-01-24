package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class KClosestPointsToOriginTest {
  private KClosestPointsToOrigin solution = new KClosestPointsToOrigin();

  @Test
  public void testLeetCodeExample1() {
    int[][] points = {
      {1, 3},
      {-2, 2}
    };
    int k = 1;
    int[][] expected = {
      {-2, 2}
    };
    int[][] actual = solution.kClosest(points, k);

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int[][] points = {
      {3, 3},
      {5, -1},
      {-2, 4}
    };
    int k = 2;
    int[][] expected = {
      {3, 3},
      {-2, 4}
    };
    int[][] actual = solution.kClosest(points, k);

    assertArrayEquals(expected, actual);
  }
}
