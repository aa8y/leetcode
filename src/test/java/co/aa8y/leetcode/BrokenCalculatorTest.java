package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BrokenCalculatorTest {
  private BrokenCalculator solution = new BrokenCalculator();

  @Test
  public void testLeetCodeExample1() {
    int expected = 2;
    int actual = solution.brokenCalc(2, 3);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int expected = 2;
    int actual = solution.brokenCalc(5, 8);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample3() {
    int expected = 3;
    int actual = solution.brokenCalc(3, 10);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample4() {
    int expected = 1023;
    int actual = solution.brokenCalc(1024, 1);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCaseX() {
    int expected = 39;

    int actual = solution.brokenCalc(1, 1000000000);

    assertEquals(expected, actual);
  }
}
