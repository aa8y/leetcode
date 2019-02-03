package co.aa8y.leetcode;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 135. Candy
 *
 * <p>There are N children standing in a line. Each child is assigned a rating value.
 *
 * <p>You are giving candies to these children subjected to the following requirements:
 * 1. Each child must have at least one candy.
 * 2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * <p>Example 1:
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies
 *              respectively.
 *
 * <p>Example 2:
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies
 *              respectively. The third child gets 1 candy because it satisfies the above two
 *              conditions.
 */
public class Candy {
  private CandyAssignment[] cache;
  private LinkedList<Integer> processStack;

  public int candy(int[] ratings) {
    if (ratings.length == 0) {
      return 0;
    }
    cache = new CandyAssignment[ratings.length];
    processStack = IntStream.range(0, ratings.length)
                            .mapToObj(Integer::valueOf)
                            .collect(Collectors.toCollection(LinkedList::new));

    while (!processStack.isEmpty()) {
      buildCandyAssignment(ratings, processStack.pop().intValue());
    }

    return IntStream.range(0, ratings.length)
                    .mapToObj(i -> getChild(ratings, i))
                    .mapToInt(CandyAssignment::getCandy)
                    .sum();
  }

  private void buildCandyAssignment(int[] ratings, int index) {
    CandyAssignment middle = getChild(ratings, index);
    Optional<CandyAssignment> left = getLeftNeighbor(ratings, index);
    Optional<CandyAssignment> right = getRightNeighbor(ratings, index);

    if (left.isPresent() && right.isPresent()) {
      CandyAssignment l = left.get();
      CandyAssignment r = right.get();

      if (middle.getRating() > l.getRating() && middle.getRating() > r.getRating()) {
        assignCandy(middle, getCandyAssignment(l, r));
      } else if (middle.getRating() > l.getRating() && middle.getRating() <= r.getRating()) {
        assignCandy(middle, getCandyAssignment(l));
      } else if (middle.getRating() <= l.getRating() && middle.getRating() > r.getRating()) {
        int candy = getCandyAssignment(r);

        if (middle.getCandy() != candy) {
          assignCandy(middle, candy);
          // Since the middle child got more candy when though it has a lesser rating than the left
          // child, we need to recalculate the candy assignment for the left one.
          processStack.push(Integer.valueOf(index - 1));
        }
      }
    } else if (!left.isPresent() && right.isPresent()) {
      CandyAssignment r = right.get();

      if (middle.getRating() > r.getRating()) {
        assignCandy(middle, getCandyAssignment(r));
      }
    } else if (left.isPresent() && !right.isPresent()) {
      CandyAssignment l = left.get();

      if (middle.getRating() > l.getRating()) {
        assignCandy(middle, getCandyAssignment(l));
      }
    } else {
      assignCandy(middle, 1);
    }
  }

  private int getCandyAssignment(CandyAssignment c) {
    return c.getCandy() + 1;
  }

  private int getCandyAssignment(CandyAssignment l, CandyAssignment r) {
    return Math.max(l.getCandy(), r.getCandy()) + 1;
  }

  private void assignCandy(CandyAssignment assignment, int candy) {
    CandyAssignment updatedAssignment = assignment.toBuilder()
                                                  .withCandy(candy)
                                                  .build();
    updateCache(updatedAssignment);
  }

  private Optional<CandyAssignment> getLeftNeighbor(int[] ratings, int index) {
    return getNeighbor(ratings, index, Neighbor.LEFT);
  }

  private Optional<CandyAssignment> getRightNeighbor(int[] ratings, int index) {
    return getNeighbor(ratings, index, Neighbor.RIGHT);
  }

  private Optional<CandyAssignment> getNeighbor(int[] ratings, int index, Neighbor neighbor) {
    switch (neighbor) {
      case LEFT:
        if (index > 0) {
          return Optional.of(getChild(ratings, index - 1));
        }
        return Optional.<CandyAssignment>empty();
      case RIGHT:
        if (index < ratings.length - 1) {
          return Optional.of(getChild(ratings, index + 1));
        }
        return Optional.<CandyAssignment>empty();
      default:
        return Optional.<CandyAssignment>empty();
    }
  }

  private CandyAssignment getChild(int[] ratings, int index) {
    return getCache(index).orElse(CandyAssignment.builder()
                                                 .withChild(index)
                                                 .withRating(ratings[index])
                                                 .build());
  }

  private Optional<CandyAssignment> getCache(int index) {
    if (index < cache.length && cache[index] != null) {
      return Optional.of(cache[index]);
    }
    return Optional.<CandyAssignment>empty();
  }

  private void updateCache(CandyAssignment assignment) {
    cache[assignment.getChild()] = assignment;
  }

  private static enum Neighbor { LEFT, RIGHT }

  private static class CandyAssignment {
    private final int candy;
    private final int child;
    private final int rating;

    private CandyAssignment(int candy, int child, int rating) {
      this.candy = candy;
      this.child = child;
      this.rating = rating;
    }

    private CandyAssignment(int child, int rating) {
      this.candy = 1;
      this.child = child;
      this.rating = rating;
    }

    public static Builder builder() {
      return new Builder();
    }

    public int getCandy() {
      return this.candy;
    }

    public int getChild() {
      return this.child;
    }

    public int getRating() {
      return this.rating;
    }

    public Builder toBuilder() {
      return new Builder(this.candy, this.child, this.rating);
    }

    static class Builder {
      private int candy;
      private int child;
      private int rating;

      protected Builder() { }

      protected Builder(int candy, int child, int rating) {
        this.candy = candy;
        this.child = child;
        this.rating = rating;
      }

      public Builder withCandy(int candy) {
        this.candy = candy;
        return this;
      }

      public Builder withChild(int child) {
        this.child = child;
        return this;
      }

      public Builder withRating(int rating) {
        this.rating = rating;
        return this;
      }

      public CandyAssignment build() {
        return this.candy == 0
          ? new CandyAssignment(this.child, this.rating)
          : new CandyAssignment(this.candy, this.child, this.rating);
      }
    }
  }
}
