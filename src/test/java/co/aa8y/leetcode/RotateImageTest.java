package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RotateImageTest {
  RotateImage solution = new RotateImage();

  @Test
  public void testLeetCodeExample1() {
    int[][] matrix = {
      { 1, 2, 3 },
      { 4, 5, 6 },
      { 7, 8, 9 },
    };
    int[][] expected = {
      { 7, 4, 1 },
      { 8, 5, 2 },
      { 9, 6, 3 }
    };
    solution.rotate(matrix);

    assertArrayEquals(expected, matrix);
  }

  @Test
  public void testLeetCodeExample2() {
    int[][] matrix = {
      {  5,  1,  9, 11 },
      {  2,  4,  8, 10 },
      { 13,  3,  6,  7 },
      { 15, 14, 12, 16 }
    };
    int[][] expected = {
      { 15, 13,  2,  5 },
      { 14,  3,  4,  1 },
      { 12,  6,  8,  9 },
      { 16,  7, 10, 11 }
    };
    solution.rotate(matrix);

    assertArrayEquals(expected, matrix);
  }

  @Test
  public void testCustom1() {
    int[][] matrix = { { 1 } };
    int[][] expected = { { 1 } };
    solution.rotate(matrix);

    assertArrayEquals(expected, matrix);
  }

  @Test
  public void testCustom2() {
    int[][] matrix = {
      { 1, 2 },
      { 3, 4 }
    };
    int[][] expected = {
      { 3, 1 },
      { 4, 2 }
    };
    solution.rotate(matrix);

    assertArrayEquals(expected, matrix);
  }
}
