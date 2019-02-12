package co.aa8y.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
 * <p>Note:
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
    if (equations.length == 0 || equations.length == 1) {
      return true;
    }
    Map<Boolean, TreeSet<Equation>> allEqs =
        Arrays.stream(equations)
              .map(String::trim)
              .map(Equation::buildFrom)
              .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
              .collect(Collectors.partitioningBy(e -> e.getOperation() == Operation.EQUALITY,
                                                 Collectors.toCollection(TreeSet::new)));
    TreeSet<Equation> eqs = allEqs.get(true);
    TreeSet<Equation> ineqs = allEqs.get(false);
    Optional<Equation> hasNaN = ineqs.stream()
                                     .filter(Equation::isNaN)
                                     .findAny();
    if (hasNaN.isPresent()) {
      return false;
    }
    TreeSet<Equation> combinedEqs = combineEquations(eqs);

    return checkSatisfiability(combinedEqs, ineqs);
  }

  private TreeSet<Equation> combineEquations(TreeSet<Equation> eqs) {
    TreeSet<Equation> combined = new TreeSet<>();

    while (!eqs.isEmpty()) {
      Equation next = eqs.pollFirst();
      TreeSet<Equation> localCombined = new TreeSet<>();

      for (Equation eq : eqs) {
        Optional<Equation> comb = Equation.buildFrom(next, eq);
        if (comb.isPresent() && !combined.contains(comb.get())) {
          localCombined.add(comb.get());
        }
      }
      combined.add(next);
      eqs.addAll(localCombined);
    }
    return combined;
  }

  private boolean checkSatisfiability(TreeSet<Equation> eqs, TreeSet<Equation> ineqs) {
    while (!eqs.isEmpty() && !ineqs.isEmpty()) {
      Equation eq = eqs.pollFirst();
      Equation ineq = ineqs.pollFirst();

      if (eq.getLeft() > ineq.getLeft()) {
        eqs.add(eq);
      } else if (eq.getLeft() < ineq.getLeft()) {
        ineqs.add(ineq);
      } else {
        if (eq.getRight() > ineq.getRight()) {
          eqs.add(eq);
        } else if (eq.getRight() < ineq.getRight()) {
          ineqs.add(ineq);
        } else {
          return false;
        }
      }
    }

    return true;
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
        } else if (l < r) {
          return Optional.of(new Equation(l, r, o.get()));
        } else {
          if (o.get() == Operation.INEQUALITY) {
            return Optional.of(new Equation(l, r, Operation.INEQUALITY));
          }
        }
      }
      return Optional.empty();
    }

    public static Optional<Equation> buildFrom(Equation l, Equation r) {
      if (l.getOperation() == Operation.INEQUALITY || r.getOperation() == Operation.INEQUALITY) {
        return Optional.empty();
      }
      if (l.getLeft() == r.getLeft() && l.getRight() != r.getRight()) {
        return Optional.of(new Equation(l.getRight(), r.getRight(), Operation.EQUALITY));
      } else if (l.getLeft() != r.getLeft() && l.getRight() == r.getRight()) {
        return Optional.of(new Equation(l.getLeft(), r.getLeft(), Operation.EQUALITY));
      } else if (l.getLeft() != r.getRight() && l.getRight() == r.getLeft()) {
        return Optional.of(new Equation(l.getLeft(), r.getRight(), Operation.EQUALITY));
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
