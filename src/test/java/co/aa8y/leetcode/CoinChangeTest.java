package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoinChangeTest {
  private CoinChange solution = new CoinChange();

  @Test
  public void testLeetCodeExample1() {
    int[] coins = { 1, 2, 5 };
    int amount = 11;
    int expected = 3;
    int actual = solution.coinChange(coins, amount);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    int[] coins = { 2 };
    int amount = 3;
    int expected = -1;
    int actual = solution.coinChange(coins, amount);

    assertEquals(expected, actual);
  }
}
