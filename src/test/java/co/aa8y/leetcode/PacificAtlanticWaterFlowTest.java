package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PacificAtlanticWaterFlowTest {
  private PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();

  @Test
  public void testLeetCodeExample1() {
    int[][] matrix = {
      { 1, 2, 2, 3, 5 },
      { 3, 2, 3, 4, 4 },
      { 2, 4, 5, 3, 1 },
      { 6, 7, 1, 4, 5 },
      { 5, 1, 1, 2, 4 }
    };
    List<int[]> expected = Arrays.asList(
        new int[]{ 0, 4 },
        new int[]{ 1, 3 },
        new int[]{ 1, 4 },
        new int[]{ 2, 2 },
        new int[]{ 3, 0 },
        new int[]{ 3, 1 },
        new int[]{ 4, 0 }
    );
    List<int[]> actual = solution.pacificAtlantic(matrix);

    assertListOfIntArrayEquals(expected, actual);
  }

  /*
  @Test
  public void testLeetCodeTestCode51() {
    int[][] matrix = {
      { 1, 2, 3 },
      { 8, 9, 4 },
      { 7, 6, 5 }
    };
    List<int[]> expected = Arrays.asList(
        new int[]{ 0, 2 },
        new int[]{ 1, 0 },
        new int[]{ 1, 1 },
        new int[]{ 1, 2 },
        new int[]{ 2, 0 },
        new int[]{ 2, 1 },
        new int[]{ 2, 2 }
    );
    List<int[]> actual = solution.pacificAtlantic(matrix);

    assertListOfIntArrayEquals(expected, actual);
  }
  */

  private void assertListOfIntArrayEquals(List<int[]> expected, List<int[]> actual) {
    assertEquals(expected.size(), actual.size());
    for (int i = 0; i < expected.size(); i++) {
      assertArrayEquals(expected.get(i), actual.get(i));
    }
  }
}
