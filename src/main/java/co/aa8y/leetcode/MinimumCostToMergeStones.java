package co.aa8y.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1000. Minimum Cost to Merge Stones
 *
 * <p>There are {@code N} piles of stones arranged in a row. The {@code i}-th pile has
 * {@code stones[i]} stones.
 *
 * <p>A move consists of merging exactly {@code K} consecutive piles into one pile, and the cost
 * of this move is equal to the total number of stones in these {@code K} piles.
 *
 * <p>Find the minimum cost to merge all piles of stones into one pile. If it is impossible, return
 * {@code -1}.
 *
 * <p>Example 1:
 * Input: stones = [3,2,4,1], K = 2
 * Output: 20
 * Explanation:
 * We start with [3, 2, 4, 1].
 * We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
 * We merge [4, 1] for a cost of 5, and we are left with [5, 5].
 * We merge [5, 5] for a cost of 10, and we are left with [10].
 * The total cost was 20, and this is the minimum possible.
 *
 * <p>Example 2:
 * Input: stones = [3,2,4,1], K = 3
 * Output: -1
 * Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore. So
 * the task is impossible.
 *
 * <p>Example 3:
 * Input: stones = [3,5,1,2,6], K = 3
 * Output: 25
 * Explanation:
 * We start with [3, 5, 1, 2, 6].
 * We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
 * We merge [3, 8, 6] for a cost of 17, and we are left with [17].
 * The total cost was 25, and this is the minimum possible.
 *
 * <p>Note:
 * 1. {@code 1 <= stones.length <= 30}
 * 2. {@code 2 <= K <= 30}
 * 3. {@code 1 <= stones[i] <= 100}
 */
public class MinimumCostToMergeStones {
  private Map<List<Integer>, Integer> costCache = new HashMap<>();

  /**
   * Merges k piles of stones at once to form one big pile with minimum cost.
   *
   * @param stones All piles of stones
   * @param k Number of consecutive piles which can be combined at once
   * @return Minimum cost to combine the piles
   */
  public int mergeStones(int[] stones, int k) {
    return minCost(Arrays.stream(stones)
                         .boxed()
                         .collect(Collectors.toList()), k);
  }

  private Integer minCost(List<Integer> stones, int k) {
    int len = stones.size();

    if (len == 0 || len == 1) {
      return 0;
    }
    if (len < k) {
      return -1;
    }
    if (len == k) {
      return costCache.getOrDefault(stones, sum(stones));
    }
    if (costCache.containsKey(stones)) {
      return costCache.get(stones);
    }
    Integer cost = IntStream.range(0, len - k + 1)
                            .map(i -> {
                              List<Integer> l = new ArrayList<>(len - k + 1);
                              l.addAll(stones.subList(0, i));
                              Integer m = sum(stones.subList(i, i + k));
                              l.add(m);
                              l.addAll(stones.subList(i + k, len));

                              Integer min = minCost(l, k);
                              return min == -1 ? min : m + min;
                            })
                            .min()
                            .orElse(-1);
    costCache.put(stones, cost);
    return cost;
  }

  private Integer sum(List<Integer> is) {
    return is.stream()
             .collect(Collectors.summingInt(Integer::intValue));
  }
}
