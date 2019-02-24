package co.aa8y.leetcode;

import static co.aa8y.leetcode.testutils.FileUtil.readLines;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinimumWindowSubstringTest {
  private MinimumWindowSubstring solution = new MinimumWindowSubstring();

  @Test
  public void testLeetCodeExample1() {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    String expected = "BANC";
    String actual = solution.minWindow(s, t);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase51() {
    String s = "a";
    String t = "aa";
    String expected = "";
    String actual = solution.minWindow(s, t);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase156() {
    String s = "bdab";
    String t = "ab";
    String expected = "ab";
    String actual = solution.minWindow(s, t);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase268() {
    String s = readLines("/76_MinimumWindowSubstring_LeetCodeTestCase268_S.txt").get(0);
    String t = readLines("/76_MinimumWindowSubstring_LeetCodeTestCase268_T.txt").get(0);
    String expected = readLines("/76_MinimumWindowSubstring_LeetCodeTestCase268_Expected.txt").get(0);
    String actual = solution.minWindow(s, t);

    assertEquals(expected, actual);
  }
}
