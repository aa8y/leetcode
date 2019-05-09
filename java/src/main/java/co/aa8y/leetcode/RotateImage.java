package co.aa8y.leetcode;

/**
 * 48. Rotate Image
 *
 * <p>You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees
 * (clockwise).
 *
 * <p>Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix
 * directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * <p>Example 1:
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * <p>Example 2:
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage {
  /**
   * Rotates the given matrix, inplace, by 90 degress clockwise.
   *
   * @param matrix Matrix to be rotated
   */
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    if (n == 0 || n == 1) {
      return;
    }
    int half = n / 2;
    int outer = isOdd(n) ? half + 1 : half;

    for (int i = 0; i < outer; i++) {
      for (int j = 0; j < half; j++) {
        rotate(matrix, i, j);
      }
    }
  }

  private void rotate(int[][] matrix, int i, int j) {
    int n = matrix.length - 1;
    final int tmp = matrix[i][j];

    matrix[i][j] = matrix[n - j][i];          // BottomLeft -> TopLeft
    matrix[n - j][i] = matrix[n - i][n - j];  // BottomRight -> BottomLeft
    matrix[n - i][n - j] = matrix[j][n - i];  // TopRight -> BottomRight
    matrix[j][n - i] = tmp;                   // TopLeft -> TopRight
  }

  private boolean isOdd(int n) {
    return n % 2 == 1;
  }
}
