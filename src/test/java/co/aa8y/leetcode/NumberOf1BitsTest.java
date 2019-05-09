package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberOf1BitsTest {
  private final NumberOf1BitsIterative solutionIterative = new NumberOf1BitsIterative();
  private final NumberOf1BitsRecursive solutionRecursive = new NumberOf1BitsRecursive();

  @Test
  public void testLeetCodeExample1() {
    int n = 0b00000000000000000000000000001011;
    int expected = 3;
    int actualIterative = solutionIterative.hammingWeight(n);
    int actualRecursive = solutionRecursive.hammingWeight(n);

    assertEquals(expected, actualIterative);
    assertEquals(expected, actualRecursive);
  }

  @Test
  public void testLeetCodeExample2() {
    int n = 0b00000000000000000000000010000000;
    int expected = 1;
    int actualIterative = solutionIterative.hammingWeight(n);
    int actualRecursive = solutionRecursive.hammingWeight(n);

    assertEquals(expected, actualIterative);
    assertEquals(expected, actualRecursive);
  }

  @Test
  public void testLeetCodeExample3() {
    int n = 0b11111111111111111111111111111101;
    int expected = 31;
    int actualIterative = solutionIterative.hammingWeight(n);
    int actualRecursive = solutionRecursive.hammingWeight(n);

    assertEquals(expected, actualIterative);
    assertEquals(expected, actualRecursive);
  }
}
