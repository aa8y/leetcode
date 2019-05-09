package co.aa8y.leetcode;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;

/**
 * 417. Pacific Atlantic Water Flow
 *
 * <p>Given an m x n matrix of non-negative integers representing the height of each unit cell in a
 * continent, the "Pacific ocean" touches the left and top edges of the matrix and the
 * "Atlantic ocean" touches the right and bottom edges.
 *
 * <p>Water can only flow in four directions (up, down, left, or right) from a cell to another one
 * with height equal or lower.
 *
 * <p>Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * <p>Note:
 * 1. The order of returned grid coordinates does not matter.
 * 2. Both m and n are less than 150.
 *
 * <p>Example:
 * Given the following 5x5 matrix:
 * <pre>
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 * </pre>
 * Return:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
 * (positions with parentheses in above matrix).
 */
public class PacificAtlanticWaterFlow {
  /**
   * Finds all valid flows from Pacific to Atlantic ocean.
   *
   * @param matrix Matrix with cell heights
   * @return List of cells from where flow is possible
   */
  public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> flows = new LinkedList<>();
    OptionalInt height = OptionalInt.empty();

    if (matrix.length == 0 || matrix[0].length == 0) {
      return flows;
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (doesFlowToAtlantic(matrix, i, j, height) && doesFlowToPacific(matrix, i, j, height)) {
          flows.add(new int[]{ i, j });
        }
      }
    }
    return flows;
  }

  private Boolean doesFlowToAtlantic(int[][] matrix, int i, int j, OptionalInt fromHeight) {
    // i < 0 denotes the Top edge
    // j < 0 denotes the Left edge
    if (i < 0 || j < 0) {
      return FALSE;
    }
    // i >= m denotes the Bottom edge
    // j >= n denotes the Right edge
    if (i >= matrix.length || j >= matrix[0].length) {
      return TRUE;
    }
    int currentHeight = matrix[i][j];

    Boolean flow = fromHeight.isPresent() ? fromHeight.getAsInt() >= currentHeight : TRUE;
    flow = flow && (doesFlowToAtlantic(matrix, i, j + 1, OptionalInt.of(currentHeight))
                ||  doesFlowToAtlantic(matrix, i + 1, j, OptionalInt.of(currentHeight)));

    return flow;
  }

  private Boolean doesFlowToPacific(int[][] matrix, int i, int j, OptionalInt fromHeight) {
    // i < 0 denotes the Top edge
    // j < 0 denotes the Left edge
    if (i < 0 || j < 0) {
      return TRUE;
    }
    // i >= m denotes the Bottom edge
    // j >= n denotes the Right edge
    if (i >= matrix.length || j >= matrix[0].length) {
      return FALSE;
    }
    int currentHeight = matrix[i][j];

    Boolean flow = fromHeight.isPresent() ? fromHeight.getAsInt() >= currentHeight : TRUE;
    flow = flow && (doesFlowToPacific(matrix, i, j - 1, OptionalInt.of(currentHeight))
                ||  doesFlowToPacific(matrix, i - 1, j, OptionalInt.of(currentHeight)));

    return flow;
  }
}
