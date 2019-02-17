package co.aa8y.leetcode;

import java.util.OptionalInt;

/**
 * 240. Search a 2D Matrix II
 *
 * <p>Write an efficient algorithm that searches for a value in an m x n matrix. This matrix
 * has the following properties:
 * 1. Integers in each row are sorted in ascending from left to right.
 * 2. Integers in each column are sorted in ascending from top to bottom.
 *
 * <p>Example:
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class SearchA2DMatrix2 {
  /**
   * Determines if the given target is present in the given matrix or not.
   *
   * @param matrix Matrix to find the target in
   * @param target Target to look for
   * @return true if the target is present, else false
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int m = matrix[0].length;
    int n = matrix.length;

    return searchMatrix(matrix, target, 0, m - 1, 0, n - 1);
  }

  private boolean searchMatrix(int[][] matrix,
                               int target,
                               int mStart,
                               int mEnd,
                               int nStart,
                               int nEnd) {
    if ((mStart == mEnd
      && nStart == nEnd
      && mStart == nStart
      && target != matrix[mStart][nStart])
      || mStart > mEnd
      || nStart > nEnd) {
      return false;
    }
    int m = (mStart + mEnd) / 2;
    int n = (nStart + nEnd) / 2;
    OptionalInt possibleTarget = getPossibleTarget(matrix, m, n);

    if (!possibleTarget.isPresent()) {
      return false;
    }
    if (target == possibleTarget.getAsInt()) {
      return true;
    }

    if (target > possibleTarget.getAsInt()) {
      return searchMatrix(matrix, target, m + 1, mEnd, n + 1, nEnd)      // Bottom-right quadrant
        || searchMatrix(matrix, target, m + 1, mEnd, nStart, n)   // Bottom-left quadrant
        || searchMatrix(matrix, target, mStart, m, n + 1, nEnd);  // Top-right quadrant
    } else {
      return searchMatrix(matrix, target, mStart, m - 1, nStart, n - 1)  // Top-right quadrant
        || searchMatrix(matrix, target, m - 1, mEnd, nStart, n - 1)   // Bottom-left quadrant
        || searchMatrix(matrix, target, mStart, m - 1, n, nEnd);  // Top-right quadrant
    }
  }

  private OptionalInt getPossibleTarget(int[][] matrix, int m, int n) {
    if (m < 0 || n < 0 || m > matrix[0].length || n > matrix.length) {
      return OptionalInt.empty();
    }
    return OptionalInt.of(matrix[n][m]);
  }
}
