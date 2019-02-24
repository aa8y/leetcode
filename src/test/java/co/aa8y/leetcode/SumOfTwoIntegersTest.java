package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SumOfTwoIntegersTest {
  private final SumOfTwoIntegers solution = new SumOfTwoIntegers();

  @Test
  public void testLeetCodeExample1() {
    test(1, 2);
  }

  @Test
  public void testLeetCodeExample2() {
    test(-2, 3);
  }

  @Test
  public void testLeetCodeTestCase9() {
    test(2, 3);
  }

  @Test
  public void testCustom1() {
    test(4, 2);
  }

  @Test
  public void testCustom2() {
    test(-1, -2);
  }

  private void test(int a, int b) {
    int expected = a + b;
    int actual = solution.getSum(a, b);

    assertEquals(expected, actual);
  }
}
