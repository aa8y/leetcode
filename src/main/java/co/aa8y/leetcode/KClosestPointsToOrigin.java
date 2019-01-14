package co.aa8y.leetcode;

import java.lang.Math;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h1>
 * 973. K Closest Points to Origin
 * </h1>
 *
 * <p>
 * We have a list of points on the plane. Find the K closest points to the origin (0, 0).
 * </p>
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * </p>
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the
 * order that it is in.)
 * </p>
 * <h3>
 * Example 1:
 * </h3>
 * <pre>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 *   The distance between (1, 3) and the origin is sqrt(10).
 *   The distance between (-2, 2) and the origin is sqrt(8).
 *   Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 *   We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * </pre>
 *
 * <h3>
 * Example 2:
 * </h3>
 * <pre>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * </pre>
 * <h3>
 * Note:
 * </h3>
 * <p>
 * 1. 1 <= K <= points.length <= 10000
 * 2. -10000 < points[i][0] < 10000
 * 3. -10000 < points[i][1] < 10000
 * </p>
 */
public class KClosestPointsToOrigin {
  static class PointDistance {
    private int[] point;
    private double distance;

    public PointDistance() {}

    public PointDistance(int[] point, double distance) {
      this.point = point;
      this.distance = distance;
    }

    public int[] getPoint() {
      return this.point;
    }

    public double getDistance() {
      return this.distance;
    }

    public void setPoint(int[] point) {
      this.point = point;
    }

    public void setDistance(double distance) {
      this.distance = distance;
    }
  }

  static class PointDistanceComparator implements Comparator<PointDistance> {
    public int compare(PointDistance l, PointDistance r) {
      if (l.getDistance() < r.getDistance()) {
        return -1;
      } else if (l.getDistance() > r.getDistance()) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  private static final double INVALID_DISTANCE = -1D;
  private static final int POINT_ARRAY_SIZE = 2;

  public int[][] kClosest(int[][] points, int k) {
    if (k == 0) {
      return new int[k][POINT_ARRAY_SIZE];
    }

    PriorityQueue<PointDistance> pointDistances =
        new PriorityQueue<>(k, new PointDistanceComparator());

    for (int[] point : points) {
      double distance = euclideanDistanceFromOrigin(point);
      if (distance != INVALID_DISTANCE) {
        pointDistances.add(new PointDistance(point, distance));
      }
    }

    int[][] kClosestPoints = new int[k][POINT_ARRAY_SIZE];
    for (int i = 0; i < k; i++) {
      kClosestPoints[i] = pointDistances.poll().getPoint();
    }

    return kClosestPoints;
  }

  private double euclideanDistanceFromOrigin(int[] point) {
    if (point == null || point.length != POINT_ARRAY_SIZE) {
      return INVALID_DISTANCE;
    }

    double x = new Integer(point[0]).doubleValue();
    double y = new Integer(point[1]).doubleValue();

    return Math.sqrt(x * x + y * y);
  }
}
