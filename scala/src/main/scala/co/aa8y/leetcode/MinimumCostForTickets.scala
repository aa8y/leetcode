package co.aa8y.leetcode

import scala.annotation.tailrec
import scala.collection.mutable.Queue
import scala.math.min

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
 * 3. days is in strictly increasing order.
 * 4. {@code costs.length == 3}
 * 5. {@code 1 <= costs[i] <= 1000}
 * 
 * <p>Solution:
 * Re-implementation of approach 2 in Java.
 * Ref: https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226659/Two-DP-solutions-with-pictures
 */
object MinimumCostForTickets {
  case class CostTracker(day: Int, cost: Int)

  case class Pass(days: Int, passCost: Int) {
    private val q = Queue[CostTracker]()

    def isExpired(currentDay: Int): Boolean = {
      q.nonEmpty && (q.head.day + days <= currentDay)
    }

    def scan(currentDay: Int, minCost: Int) {
      q.enqueue(CostTracker(currentDay, minCost + passCost))
    }

    def renew(currentDay: Int) {
      q.dequeueAll(_.day + days <= currentDay)
    }

    def currentCost: Int = q.head.cost
  }

  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    val Array(dailyCost, weeklyCost, monthlyCost) = costs
    val weeklyPass = Pass(7, weeklyCost)
    val monthlyPass = Pass(30, monthlyCost)

    @tailrec
    def loop(days: List[Int], minCost: Int): Int = days match {
      case Nil => minCost
      case currentDay :: remaining =>
        if (weeklyPass.isExpired(currentDay)) {
          weeklyPass.renew(currentDay)
        }
        if (monthlyPass.isExpired(currentDay)) {
          monthlyPass.renew(currentDay)
        }
        weeklyPass.scan(currentDay, minCost)
        monthlyPass.scan(currentDay, minCost)

        val currentDailyCost = minCost + dailyCost
        loop(remaining, min(currentDailyCost, min(weeklyPass.currentCost, monthlyPass.currentCost)))
    }
    loop(days.toList, 0)
  }
}
