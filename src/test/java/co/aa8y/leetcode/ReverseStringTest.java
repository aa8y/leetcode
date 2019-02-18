package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class ReverseStringTest {
  private ReverseString solution = new ReverseString();

  @Test
  public void testLeetCodeExample1() {
    char[] s = { 'h', 'e', 'l', 'l', 'o' };
    char[] expected = { 'o', 'l', 'l', 'e', 'h' };

    solution.reverseString(s);
    assertArrayEquals(expected, s);
  }

  @Test
  public void testLeetCodeExample2() {
    char[] s = { 'H', 'a', 'n', 'n', 'a', 'h' };
    char[] expected = { 'h', 'a', 'n', 'n', 'a', 'H' };

    solution.reverseString(s);
    assertArrayEquals(expected, s);
  }
}
