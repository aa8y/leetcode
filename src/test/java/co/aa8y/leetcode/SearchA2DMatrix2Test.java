package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SearchA2DMatrix2Test {
  private int[][] example1Matrix = {
    { 1,   4,  7, 11, 15 },
    { 2,   5,  8, 12, 19 },
    { 3,   6,  9, 16, 22 },
    { 10, 13, 14, 17, 24 },
    { 18, 21, 23, 26, 30 }
  };
  private int[][] customMatrix1X1 = { { 1 } };
  private int[][] customMatrix1X2 = { { 1, 2 } };
  private int[][] customMatrix2X1 = {
    { 1 },
    { 2 }
  };
  private int[][] customMatrix2X2 = {
    { 1, 2 },
    { 3, 4 }
  };
  private int[][] customMatrix3X1 = {
    { 1 },
    { 2 },
    { 3 }
  };
  private SearchA2DMatrix2 solution = new SearchA2DMatrix2();

  @Test
  public void testLeetCodeExample1A() {
    int target = 5;
    boolean expected = true;
    boolean actual = solution.searchMatrix(example1Matrix, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample1B() {
    int target = 20;
    boolean expected = false;
    boolean actual = solution.searchMatrix(example1Matrix, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase117() {
    int[][] matrix = { { 1, 3, 5 } };
    int target = 1;
    boolean expected = true;
    boolean actual = solution.searchMatrix(matrix, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeTestCase12X() {
    int[][] matrix = {
      { 1 },
      { 3 },
      { 5 }
    };
    int target = 0;
    boolean expected = false;
    boolean actual = solution.searchMatrix(matrix, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample1BottomLeft() {
    int target = 18;
    boolean expected = true;
    boolean actual = solution.searchMatrix(example1Matrix, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample1BottomRight() {
    int target = 30;
    boolean expected = true;
    boolean actual = solution.searchMatrix(example1Matrix, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample1TopLeft() {
    int target = 1;
    boolean expected = true;
    boolean actual = solution.searchMatrix(example1Matrix, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample1TopRight() {
    int target = 15;
    boolean expected = true;
    boolean actual = solution.searchMatrix(example1Matrix, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1X1Present() {
    int target = 1;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix1X1, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1X1NotPresent() {
    int target = 2;
    boolean expected = false;
    boolean actual = solution.searchMatrix(customMatrix1X1, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1X2Left() {
    int target = 1;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix1X2, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1X2Right() {
    int target = 2;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix1X2, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom2X1Bottom() {
    int target = 2;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix2X1, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom2X1Top() {
    int target = 1;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix2X1, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom2X2TopLeft() {
    int target = 1;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix2X2, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom2X2TopRight() {
    int target = 2;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix2X2, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom2X2BottomLeft() {
    int target = 3;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix2X2, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom2X2BottomRight() {
    int target = 4;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix2X2, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom3X1Bottom() {
    int target = 3;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix3X1, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom3X1Middle() {
    int target = 2;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix3X1, target);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom3X1Top() {
    int target = 1;
    boolean expected = true;
    boolean actual = solution.searchMatrix(customMatrix3X1, target);

    assertEquals(expected, actual);
  }
}
