package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import co.aa8y.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

public class ValidParenthesesTest {
  private ValidParentheses solution = new ValidParentheses();

  @Test
  public void testLeetCodeExample1() {
    String s = "()";
    boolean expected = true;
    boolean actual = solution.isValid(s);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    String s = "()[]{}";
    boolean expected = true;
    boolean actual = solution.isValid(s);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample3() {
    String s = "(]";
    boolean expected = false;
    boolean actual = solution.isValid(s);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample4() {
    String s = "([)]";
    boolean expected = false;
    boolean actual = solution.isValid(s);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample5() {
    String s = "{[]}";
    boolean expected = true;
    boolean actual = solution.isValid(s);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase72() {
    String s = "[";
    boolean expected = false;
    boolean actual = solution.isValid(s);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase73() {
    String s = "((";
    boolean expected = false;
    boolean actual = solution.isValid(s);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1() {
    String s = "}[]{";
    boolean expected = false;
    boolean actual = solution.isValid(s);

    assertEquals(expected, actual);
  }
}
