package co.aa8y.leetcode;

import java.util.Arrays;

/**
 * 322. Coin Change
 *
 * <p>You are given coins of different denominations and a total amount of money amount. Write a
 * function to compute the fewest number of coins that you need to make up that amount. If that
 * amount of money cannot be made up by any combination of the coins, return -1.
 *
 * <p>Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * <p>Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * <p>Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
  // Cache which stores minimum coins needed for a each amount
  private int[] minCoins;

  /**
   * Gives the minimum change which would added to the given amount.
   *
   * @param coins Denominations of coins
   * @param amount Amount to which the coins need to sum up to
   * @return Number of coins required
   */
  public int coinChange(int[] coins, int amount) {
    // Since our max amount is capped to the given value of amount, we need an array as big as that
    minCoins = new int[amount];
    Arrays.fill(minCoins, 0);

    return loop(coins, amount);
  }

  private int loop(int[] coins, int amount) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    int minCoinsReq = minCoins[amount - 1];
    if (minCoinsReq != 0) {
      return minCoinsReq;
    }
    minCoinsReq = Arrays.stream(coins)
                        .map(coin -> loop(coins, amount - coin))
                        .filter(cnt -> cnt >= 0)
                        .min()
                        .orElse(-1);
    if (minCoinsReq != -1) {
      minCoinsReq += 1;
    }
    minCoins[amount - 1] = minCoinsReq;

    return minCoinsReq;
  }
}
