package co.aa8y.leetcode;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumCostToMergeStones {
  private Map<List<Integer>, Integer> costCache = new HashMap<>();

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
