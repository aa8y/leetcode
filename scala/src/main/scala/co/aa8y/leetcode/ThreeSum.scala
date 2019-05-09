package co.aa8y.leetcode;

import scala.annotation.tailrec

/**
 * 15. 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
object ThreeSum {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    @tailrec
    def loop(nums: List[Int], acc: Set[List[Int]]): Set[List[Int]] = {
      nums match {
        case Nil => acc
        case head :: tail =>
          val twoSums = twoSum(tail, 0 - head)
          if (twoSums.isEmpty) loop(tail, acc)
          else loop(tail, acc.union(twoSums.map(head :: _)))
      }
    }
    loop(nums.sorted.toList, Set[List[Int]]()).toList
  }

  private def twoSum(nums: List[Int], equals: Int): Set[List[Int]] = {
    @tailrec
    def loop(nums: List[Int], lookup: Map[Int, Int], acc: Set[List[Int]]): Set[List[Int]] = {
      nums match {
        case Nil => acc
        case right :: tail =>
          lookup.get(right) match {
            case Some(left) => loop(tail, lookup, acc + (left :: right :: Nil))
            case _ => loop(tail, lookup + (equals - right -> right), acc)
          }
      }
    }
    loop(nums, Map(), Set[List[Int]]())
  }
}
