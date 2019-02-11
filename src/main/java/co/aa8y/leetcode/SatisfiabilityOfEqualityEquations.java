package co.aa8y.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 990. Satisfiability of Equality Equations
 *
 * <p>Given an array equations of strings that represent relationships between variables, each
 * string {@code equations[i]} has length 4 and takes one of two different forms: "a==b" or "a!=b".
 * Here, a and b are lowercase letters (not necessarily different) that represent one-letter
 * variable names.
 *
 * <p>Return true if and only if it is possible to assign integers to variable names so as to 
 * satisfy all the given equations.
 *
 * <p>Example 1:
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not 
 *              the second. There is no way to assign the variables to satisfy both equations.
 *
 * <p>Example 2:
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 *
 * <p>Example 3:
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 *
 * <p>Example 4:
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 *
 * <p>Example 5:
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 *
 * Note:
 * 1. {@code 1 <= equations.length <= 500}
 * 2. {@code equations[i].length == 4}
 * 3. {@code equations[i][0]} and {@code equations[i][3]} are lowercase letters.
 * 4. {@code equations[i][1]} is either '=' or '!'
 * 5. {@code equations[i][2]} is '='
 */
public class SatisfiabilityOfEqualityEquations {
  /**
   * Determines if the given set of equations is possible, together, or not.
   *
   * @param equations List of equations
   * @return true if possible, else false
   */
  public boolean equationsPossible(String[] equations) {
    TreeSet<Equation> eqs = Arrays.stream(equations)
                                  .map(String::trim)
                                  .map(Equation::buildFrom)
                                  .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
                                  .collect(Collectors.toCollection(TreeSet::new));
    if (eqs.size() == 0 || eqs.size() == 1) {
      return true;
    }
    TreeSet<Equation> combinedEqs = combineEquations(eqs);
    Optional<Equation> hasNaN = combinedEqs.stream()
                                           .filter(Equation::isNaN)
                                           .findAny();
    if (hasNaN.isPresent()) {
      return false;
    }
    // for (Equation e : combinedEqs) {
    //   System.out.println(e);
    // }

    while (combinedEqs.size() > 1) {
      Equation prev = combinedEqs.pollFirst();
      Equation curr = combinedEqs.pollFirst();
      // System.out.println("Previous: " + prev);
      // System.out.println("Current:  " + curr);

      if (prev.getOperation() != curr.getOperation()) {
        if (prev.getLeft() == curr.getLeft() && prev.getRight() == curr.getRight()) {
          return false;
        }
        combinedEqs.add(curr);
      } else {
        combinedEqs.add(curr);
      }
    }
    return true;
  }

  private TreeSet<Equation> combineEquations(TreeSet<Equation> eqs) {
    TreeSet<Equation> combined = new TreeSet<>();

    while (eqs.size() > 1) {
      Equation prev = eqs.pollFirst();
      Equation curr = eqs.pollFirst();

      if (prev.getOperation() != curr.getOperation()
          && prev.getLeft() == curr.getLeft()
          && prev.getRight() == curr.getRight()) {
        eqs.add(new Equation(prev.getLeft(), curr.getLeft(), Operation.INEQUALITY));
      } else if (prev.getOperation() == Operation.EQUALITY
                 && curr.getOperation() == Operation.EQUALITY) {
        if (prev.getLeft() == curr.getLeft() && prev.getRight() != curr.getRight()) {
          eqs.add(new Equation(prev.getRight(), curr.getRight(), Operation.EQUALITY));
        } else if (prev.getLeft() != curr.getLeft() && prev.getRight() == curr.getRight()) {
          eqs.add(new Equation(prev.getLeft(), curr.getLeft(), Operation.EQUALITY));
        } else if (prev.getLeft() != curr.getRight() && prev.getRight() == curr.getLeft()) {
          eqs.add(new Equation(prev.getLeft(), curr.getRight(), Operation.EQUALITY));
        } else {
          combined.add(prev);
          eqs.add(curr);
        }
      } else {
        combined.add(prev);
        eqs.add(curr);
      }
    }
    if (!eqs.isEmpty()) {
      combined.add(eqs.pollFirst());
    }
    return combined;
  }

  private static enum Operation {
    EQUALITY("=="),
    INEQUALITY("!=");

    private String symbol;

    Operation(String symbol) {
      this.symbol = symbol;
    }

    public String getSymbol() {
      return this.symbol;
    }

    public static Optional<Operation> fromString(String symbol) {
      return Arrays.stream(Operation.values())
                   .filter(e -> e.getSymbol().equals(symbol))
                   .findFirst();
    }

    @Override
    public String toString() {
      return this.symbol;
    }
  }

  private static class Equation implements Comparable<Equation> {
    private final char left;
    private final char right;
    private final Operation operation;

    public Equation(char left, char right, Operation operation) {
      this.left = left;
      this.right = right;
      this.operation = operation;
    }

    public static Optional<Equation> buildFrom(String equation) {
      if (equation.length() != 4) {
        return Optional.empty();
      }
      char l = equation.charAt(0);
      char r = equation.charAt(3);

      Optional<Operation> o = Operation.fromString(equation.substring(1, 3));

      if (o.isPresent()) {
        if (l > r) {
          return Optional.of(new Equation(r, l, o.get()));
        }
        return Optional.of(new Equation(l, r, o.get()));
      }
      return Optional.empty();
    }

    @Override
    public int compareTo(Equation that) {
      if (this == that) {
        return 0;
      }
      if (this.left > that.left) {
        return 1;
      } else if (this.left < that.left) {
        return -1;
      } else {
        if (this.right > that.right) {
          return 1;
        } else if (this.right < that.right) {
          return -1;
        } else {
          if (this.operation == Operation.INEQUALITY && that.operation == Operation.EQUALITY) {
            return -1;
          } else if (this.operation == Operation.EQUALITY
                  && that.operation == Operation.INEQUALITY) {
            return 1;
          } else {
            return 0;
          }
        }
      }
    }

    public char getLeft() {
      return this.left;
    }

    public char getRight() {
      return this.right;
    }

    public Operation getOperation() {
      return this.operation;
    }

    /**
     * Checks the NaN condition for an equation which is {@code x!=x}.
     */
    public boolean isNaN() {
      return this.operation == Operation.INEQUALITY && this.left == this.right;
    }

    @Override
    public String toString() {
      return this.left + this.operation.toString() + this.right;
    }
  }
}
