package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestCommonPrefixTest {
  private LongestCommonPrefixQuadratic solutionQuadratic = new LongestCommonPrefixQuadratic();
  private LongestCommonPrefixTrie solutionTrie = new LongestCommonPrefixTrie();

  @Test
  public void testLeetCodeExample1() {
    String[] strs = { "flower", "flow", "flight" };
    test(strs, "fl");
  }

  @Test
  public void testLeetCodeExample2() {
    String[] strs = { "dog", "racecar", "car" };
    test(strs, "");
  }

  @Test
  public void testLeetCodeTestCase090() {
    String[] strs = { "", "b" };
    test(strs, "");
  }

  @Test
  public void testLeetCodeTestCase098() {
    String[] strs = { "aa", "a" };
    test(strs, "a");
  }

  @Test
  public void testLeetCodeTestCase117() {
    String[] strs = { "aca", "cba" };
    test(strs, "");
  }

  private void test(String[] input, String expected) {
    String actualQuadratic = solutionQuadratic.longestCommonPrefix(input);
    String actualTrie = solutionTrie.longestCommonPrefix(input);

    assertEquals(expected, actualQuadratic);
    assertEquals(expected, actualTrie);
  }
}
