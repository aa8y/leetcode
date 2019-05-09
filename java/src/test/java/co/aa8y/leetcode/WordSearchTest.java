package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordSearchTest {
  WordSearch solution = new WordSearch();

  private char[][] leetCodeExampleBoard = {
    { 'A', 'B', 'C', 'E' },
    { 'S', 'F', 'C', 'S' },
    { 'A', 'D', 'E', 'E' }
  };

  @Test
  public void testLeetCodeExample1() {
    boolean expected = true;
    boolean actual = solution.exist(leetCodeExampleBoard, "ABCCED");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    boolean expected = true;
    boolean actual = solution.exist(leetCodeExampleBoard, "SEE");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample3() {
    boolean expected = false;
    boolean actual = solution.exist(leetCodeExampleBoard, "ABCB");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase64() {
    char[][] board = { { 'a' } };
    boolean expected = true;
    boolean actual = solution.exist(board, "a");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase81() {
    char[][] board = {
      { 'a', 'b' },
      { 'c', 'd' }
    };
    boolean expected = false;
    boolean actual = solution.exist(board, "abcd");

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase84() {
    char[][] board = {
      { 'A', 'B', 'C', 'E' },
      { 'S', 'F', 'E', 'S' },
      { 'A', 'D', 'E', 'E' }
    };
    boolean expected = true;
    boolean actual = solution.exist(board, "ABCEFSADEESE");

    assertEquals(expected, actual);
  }
}
