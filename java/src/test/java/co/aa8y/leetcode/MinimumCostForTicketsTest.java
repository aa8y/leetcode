package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinimumCostForTicketsTest {
  private MinimumCostForTickets solution = new MinimumCostForTickets();

  @Test
  public void testLeetCodeExample1() {
    int[] days = {1, 4, 6, 7, 8, 20};
    int[] costs = {2, 7, 15};
    int expected = 11;
    int actual = solution.mincostTickets(days, costs);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
    int[] costs = {2, 7, 15};
    int expected = 17;
    int actual = solution.mincostTickets(days, costs);

    assertEquals(expected, actual);
  }

  @Test
  public void testCustom1() {
    int[] days = {1, 4, 6, 7, 8, 9, 20};
    int[] costs = {2, 7, 15};
    int expected = 11;
    int actual = solution.mincostTickets(days, costs);

    assertEquals(expected, actual);
  }
}
