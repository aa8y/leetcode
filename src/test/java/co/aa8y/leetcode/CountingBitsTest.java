package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class CountingBitsTest {
  // private final CountingBitsLinear solutionLinear = new CountingBitsLinear();
  private final CountingBitsQuadratic solutionQuadratic = new CountingBitsQuadratic();

  @Test
  public void testLeetCodeExample1() {
    int n = 2;
    int[] expected = {0, 1, 1};
    // int[] actualLinear = solutionLinear.countBits(n);
    int[] actualQuadratic = solutionQuadratic.countBits(n);

    // assertArrayEquals(expected, actualLinear);
    assertArrayEquals(expected, actualQuadratic);
  }

  @Test
  public void testLeetCodeExample2() {
    int n = 5;
    int[] expected = {0, 1, 1, 2, 1, 2};
    // int[] actualLinear = solutionLinear.countBits(n);
    int[] actualQuadratic = solutionQuadratic.countBits(n);

    // assertArrayEquals(expected, actualLinear);
    assertArrayEquals(expected, actualQuadratic);
  }
}
