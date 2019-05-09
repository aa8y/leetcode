package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberOfIslandsTest {
  private NumberOfIslandsDfs solutionDfs = new NumberOfIslandsDfs();

  @Test
  public void testLeetCodeExample1() {
    char[][] grid = {
      { '1', '1', '1', '1', '0' },
      { '1', '1', '0', '1', '0' },
      { '1', '1', '0', '0', '0' },
      { '0', '0', '0', '0', '0' }
    };
    int expected = 1;
    int actual = solutionDfs.numIslands(grid);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    char[][] grid = {
      { '1', '1', '0', '0', '0' },
      { '1', '1', '0', '0', '0' },
      { '0', '0', '1', '0', '0' },
      { '0', '0', '0', '1', '1' }
    };
    int expected = 3;
    int actual = solutionDfs.numIslands(grid);

    assertEquals(expected, actual);
  }
}
