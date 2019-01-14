package co.aa8y.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class KClosestPointsToOriginTest {
  KClosestPointsToOrigin kClosestPointsToOrigin;

  @Before
  public void setup() {
    kClosestPointsToOrigin = new KClosestPointsToOrigin();
  }

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
    int[][] actual = kClosestPointsToOrigin.kClosest(points, k);

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
    int[][] actual = kClosestPointsToOrigin.kClosest(points, k);

    assertArrayEquals(expected, actual);
  }
}
