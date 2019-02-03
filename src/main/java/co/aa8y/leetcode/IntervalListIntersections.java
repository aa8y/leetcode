package co.aa8y.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 986. Interval List Intersections
 *
 * <p>Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted
 * order.
 * 
 * <p>Return the intersection of these two interval lists.
 * 
 * <p>(Formally, a closed interval {@code [a, b]} (with {@code a <= b}) denotes the set of real 
 * numbers {@code x} with {@code a <= x <= b}. The intersection of two closed intervals is a set of
 * real numbers that is either empty, or can be represented as a closed interval. For example, the 
 * intersection of [1, 3] and [2, 4] is [2, 3].)
 * 
 * <p>Example 1:
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or
 * lists.
 * 
 * <p>Note:
 * 1. {@code 0 <= A.length < 1000}
 * 2. {@code 0 <= B.length < 1000}
 * 3. {@code 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9}
 */
public class IntervalListIntersections {
  /**
   * Interval class as expected by the LeetCode solution.
   *
   * <p>No getters or setters are defined in this class because we need to mimic LeetCode's
   * implementation of the class to make sure the solution complies on their website.
   */
  public static class Interval {
    int start;
    int end;

    public Interval() {
      this.start = 0;
      this.end = 0;
    }

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) {
        return true;
      }
      if (other instanceof Interval) {
        Interval that = (Interval) other;
        return this.start == that.start && this.end == that.end;
      }
      return false;
    }

    @Override
    public String toString() {
      return "{\"start\": " + this.start + ", \"end\": " + this.end + "}";
    }
  }

  /**
   * Calulates the intersection between the two list of intervals.
   *
   * @param a Interval list A
   * @param b Interval list B
   * @return Intersection between the two list of intervals
   */
  public Interval[] intervalIntersection(Interval[] a, Interval[] b) {
    Queue<Interval> left = new LinkedList<>(Arrays.asList(a));
    Queue<Interval> right = new LinkedList<>(Arrays.asList(b));
    Queue<Interval> intersections = new LinkedList<>();

    while (!left.isEmpty() && !right.isEmpty()) {
      Interval l = left.peek();
      Interval r = right.peek();

      if (haveOverlap(l, r)) {
        Interval intersection = getIntersection(l, r);
        intersections.add(intersection);
      }
      if (l.end < r.end) {
        left.remove();
      } else if (l.end > r.end) {
        right.remove();
      } else {
        left.remove();
        right.remove();
      }
    }

    return intersections.toArray(new Interval[intersections.size()]);
  }

  private boolean haveOverlap(Interval l, Interval r) {
    return (r.start <= l.start && l.start <= r.end)
        || (r.start <= l.end && l.end <= r.end)
        || (l.start <= r.start && r.start <= l.end)
        || (l.start <= r.end && r.end <= l.end);
  }

  private Interval getIntersection(Interval l, Interval r) {
    return new Interval(Math.max(l.start, r.start), Math.min(l.end, r.end));
  }
}
