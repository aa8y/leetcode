package co.aa8y.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 983. Minimum Cost For Tickets
 *
 * <p>In a country popular for train travel, you have planned some train travelling one year in 
 * advance. The days of the year that you will travel is given as an array days. Each day is an
 * integer from 1 to 365.
 * 
 * <p>Train tickets are sold in 3 different ways:
 * 1. a 1-day pass is sold for costs[0] dollars;
 * 2. a 7-day pass is sold for costs[1] dollars;
 * 3. a 30-day pass is sold for costs[2] dollars.
 *
 * <p>The passes allow that many days of consecutive travel. For example, if we get a 7-day pass on
 * day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 * 
 * <p>Return the minimum number of dollars you need to travel every day in the given list of days.
 * 
 * <p>Example 1:
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 *
 * <p>Example 2:
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 * 
 * <p>Note:
 * 1. {@code 1 <= days.length <= 365}
 * 2. {@code 1 <= days[i] <= 365}
 * 3. {@code days} is in strictly increasing order.
 * 4. {@code costs.length == 3}
 * 5. {@code 1 <= costs[i] <= 1000}
 * 
 * <p>Solution:
 * Re-implementation of approach 2 in Java.
 * Ref: https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226659/Two-DP-solutions-with-pictures
 */
public class MinimumCostForTickets {
  /**
   * Gives the minimum cost of the tickets for the given days given the daily, weekly and monthy
   * prices of the tickets.
   *
   * @param days Days of travel
   * @param costs Daily, weekly and montly travel prices in the 0th, 1st and 2nd indices of the
   *              array respectively.
   * @return Minimum cost of travel
   */
  public int mincostTickets(int[] days, int[] costs) {
    int minCost = 0;
    int dailyCost = costs[0];
    int weeklyCost = costs[1];
    int monthlyCost = costs[2];

    Queue<PassCost> weeklyPass = new LinkedList<>();
    Queue<PassCost> monthlyPass = new LinkedList<>();

    for (int day : days) {
      while (!weeklyPass.isEmpty() && weeklyPass.peek().getDay() + 7 <= day) {
        weeklyPass.remove();
      }
      while (!monthlyPass.isEmpty() && monthlyPass.peek().getDay() + 30 <= day) {
        monthlyPass.remove();
      }
      weeklyPass.add(new PassCost(day, minCost + weeklyCost));
      monthlyPass.add(new PassCost(day, minCost + monthlyCost));

      minCost = Math.min(minCost + dailyCost, Math.min(weeklyPass.peek().getCost(),
                                                       monthlyPass.peek().getCost()));
    }

    return minCost;
  }

  private static class PassCost {
    private int day;
    private int cost;

    public PassCost(int day, int cost) {
      this.day = day;
      this.cost = cost;
    }

    public int getDay() {
      return this.day;
    }

    public int getCost() {
      return this.cost;
    }

    public void setDay(int day) {
      this.day = day;
    }

    public void setCost(int cost) {
      this.cost = cost;
    }
  }
}
