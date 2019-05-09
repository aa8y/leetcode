package co.aa8y.leetcode;

import static co.aa8y.leetcode.IntervalListIntersections.Interval;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class IntervalListIntersectionsTest {
  private IntervalListIntersections solution = new IntervalListIntersections();

  @Test
  public void testLeetCodeExample1() {
    Interval[] a = {
      new Interval(0, 2),
      new Interval(5, 10),
      new Interval(13, 23),
      new Interval(24, 25)
    };
    Interval[] b = {
      new Interval(1, 5),
      new Interval(8, 12),
      new Interval(15, 24),
      new Interval(25, 26)
    };
    Interval[] expected = {
      new Interval(1, 2),
      new Interval(5, 5),
      new Interval(8, 10),
      new Interval(15, 23),
      new Interval(24, 24),
      new Interval(25, 25)
    };
    Interval[] actual = solution.intervalIntersection(a, b);

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase31() {
    Interval[] a = {
      new Interval(1, 3),
      new Interval(5, 9)
    };
    Interval[] b = { };
    Interval[] expected = { };
    Interval[] actual = solution.intervalIntersection(a, b);

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase35() {
    Interval[] a = {
      new Interval(3, 5),
      new Interval(9, 20)
    };
    Interval[] b = {
      new Interval(4, 5),
      new Interval(7, 10),
      new Interval(11, 12),
      new Interval(14, 15),
      new Interval(16, 20)
    };
    Interval[] expected = {
      new Interval(4, 5),
      new Interval(9, 10),
      new Interval(11, 12),
      new Interval(14, 15),
      new Interval(16, 20)
    };
    Interval[] actual = solution.intervalIntersection(a, b);

    assertArrayEquals(expected, actual);
  }
}
