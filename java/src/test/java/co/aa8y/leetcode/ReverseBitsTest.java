package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseBitsTest {
  private final ReverseBitsIterative solutionIterative = new ReverseBitsIterative();
  private final ReverseBitsRecursive solutionRecursive = new ReverseBitsRecursive();

  @Test
  public void testLeetCodeExample1() {
    int n = 0b00000010100101000001111010011100;
    int expected = 0b00111001011110000010100101000000;
    int actualIterative = solutionIterative.reverseBits(n);
    int actualRecursive = solutionRecursive.reverseBits(n);

    assertEquals(expected, actualIterative);
    assertEquals(expected, actualRecursive);
  }

  @Test
  public void testLeetCodeExample2() {
    int n = 0b11111111111111111111111111111101;
    int expected = 0b10111111111111111111111111111111;
    int actualIterative = solutionIterative.reverseBits(n);
    int actualRecursive = solutionRecursive.reverseBits(n);

    assertEquals(expected, actualIterative);
    assertEquals(expected, actualRecursive);
  }

  @Test
  public void testCustom1() {
    int n = 1;
    int expected = Integer.MIN_VALUE;
    int actualIterative = solutionIterative.reverseBits(n);
    int actualRecursive = solutionRecursive.reverseBits(n);

    assertEquals(expected, actualIterative);
    assertEquals(expected, actualRecursive);
  }
}
