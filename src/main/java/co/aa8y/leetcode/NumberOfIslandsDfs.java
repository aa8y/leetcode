package co.aa8y.leetcode;

/**
 * 200. Number of Islands
 *
 * <p>Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You
 * may assume all four edges of the grid are all surrounded by water.
 *
 * <p>Example 1:
 * Input:
 *   11110
 *   11010
 *   11000
 *   00000
 * Output: 1
 *
 * <p>Example 2:
 * Input:
 *   11000
 *   11000
 *   00100
 *   00011
 * Output: 3
*/
public class NumberOfIslandsDfs {
  private static final char LAND = '1';

  /**
   * Navigates through the grid and finds all the islands.
   *
   * @param grid Grid consistings of water and land bodies represented by 0 and 1 respectively.
   * @return Number of islands.
   */
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int count = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == LAND && !visited[i][j]) {
          explore(grid, i, j, visited);
          count++;
        }
      }
    }
    return count;
  }

  private void explore(char[][] grid, int i, int j, boolean[][] visited) {
    visited[i][j] = true;
    char curr = grid[i][j];

    if (isInBounds(grid, i, j - 1) && isConnected(curr, grid[i][j - 1]) && !visited[i][j - 1]) {
      explore(grid, i, j - 1, visited);     // Left
    }
    if (isInBounds(grid, i, j + 1) && isConnected(curr, grid[i][j + 1]) && !visited[i][j + 1]) {
      explore(grid, i, j + 1, visited);     // Right
    }
    if (isInBounds(grid, i - 1, j) && isConnected(curr, grid[i - 1][j]) && !visited[i - 1][j]) {
      explore(grid, i - 1, j, visited);     // Top
    }
    if (isInBounds(grid, i + 1, j) && isConnected(curr, grid[i + 1][j]) && !visited[i + 1][j]) {
      explore(grid, i + 1, j, visited);     // Bottom
    }
  }

  private boolean isInBounds(char[][] grid, int i, int j) {
    return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
  }

  private boolean isConnected(char l, char r) {
    return l == LAND && r == LAND;
  }
}
