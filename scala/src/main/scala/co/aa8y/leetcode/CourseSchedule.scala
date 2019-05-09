package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * 207. Course Schedule
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1. Some courses may have
 * prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to
 * finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 * 1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 *    Read more about how a graph is represented.
 * 2. You may assume that there are no duplicate edges in the input prerequisites.
 */
object CourseSchedule {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val graph = buildGraph(prerequisites)

    @tailrec
    def loop(n: Int, stack: List[Int], visited: Set[Int]): Boolean = {
      if (n == numCourses) true
      else stack match {
        case Nil => loop(n + 1, graph.get(n + 1).getOrElse(Nil), Set())
        case head :: tail =>
          if (visited.contains(head)) false
          else loop(n, graph.get(head).getOrElse(Nil) ++ tail, visited + head)
      }
    }
    loop(0, graph.get(0).getOrElse(Nil), Set())
  }

  def buildGraph(edges: Array[Array[Int]]): Map[Int, List[Int]] = {
    edges.foldLeft(Map[Int, List[Int]]()) { (acc, edge) =>
      edge match { case Array(to, from) =>
        acc.updated(from, to :: acc.get(from).getOrElse(Nil))
      }
    }
  }
}
