package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * 934. Shortest Bridge
 *
 * In a given 2D binary array A, there are two islands. (An island is a 4-directionally connected
 * group of 1s not connected to any other 1s.)
 * 
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * 
 * Return the smallest number of 0s that must be flipped. (It is guaranteed that the answer is at
 * least 1.)
 * 
 * Example 1:
 * Input: [[0,1],[1,0]]
 * Output: 1
 * 
 * Example 2:
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * 
 * Example 3:
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * 
 * Note:
 * 1. 1 <= A.length = A[0].length <= 100
 * 2. A[i][j] == 0 or A[i][j] == 1
 */
object ShortestBridge {
  case class Index(row: Int, col: Int)
  case class Island(indices: Set[Index]) {
    lazy val cols = indices.map(_.col)
    lazy val rows = indices.map(_.row)

    lazy val maxCol = cols.max
    lazy val minCol = cols.min
    lazy val maxRow = rows.max
    lazy val minRow = rows.min

    def isConnected(index: Index): Boolean = {
      cols.contains(index.col) || rows.contains(index.row)
    }

    def withIndex(index: Index): Island = Island(indices + index)
  }
  object Island {
    def apply(index: Index): Island = Island(Set(index))
  }

  def shortestBridge(a: Array[Array[Int]]): Int = {
    val indices = getIndividualOnes(a)

    def loop(islands: Set[Island], count: Int): Int = {
      if (islands.size <= 1) count
      else {
        count
      }
    }
    loop(findIslands(indices), 0)
  }

  def join(left: Island, right: Island): Island = {
    left
  }

  def minDistance(left: Island, right: Island): Int = {
    import Math.abs

    Set(
      abs(left.maxCol - right.maxCol),
      abs(left.minCol - right.minCol),
      abs(left.maxRow - right.maxRow),
      abs(left.minRow - right.minRow)
    ).min
  }

  def findClosestIsland(left: Island, islands: Set[Island]): Island = {
    @tailrec
    def loop(left: Island, closest: Island, islands: Set[Island], distance: Int): Island = {
      if (distance == 1 || islands.isEmpty) closest
      else {
        val right = islands.head
        val remaining = islands.tail
        val newDistance = minDistance(left, right)

        if (newDistance < distance) loop(left, right, remaining, newDistance)
        else loop(left, closest, remaining, distance)
      }
    }

    val remaining = islands - left
    val right = remaining.head

    loop(left, right, remaining.tail, minDistance(left, right))
  }

  def findIslands(indices: Array[Index]): Set[Island] = {
    indices.foldLeft(Set[Island]()) { (acc, index) =>
      acc.find(_.isConnected(index)) match {
        case Some(island) => acc - island + island.withIndex(index)
        case _ => acc + Island(index)
      }
    }
  }

  def getIndividualOnes(a: Array[Array[Int]]): Array[Index] = {
    for {
      (row, ri) <- a.zipWithIndex
      (col, ci) <- row.zipWithIndex
      if (col == 1)
    } yield Index(ri, ci)
  }
}
