package co.aa8y.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 989. Add to Array-Form of Integer
 *
 * <p>For a non-negative integer X, the array-form of X is an array of its digits in left to right 
 * order. For example, if X = 1231, then the array form is [1,2,3,1].
 * 
 * <p>Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 * 
 * <p>Example 1:
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 *
 * <p>Example 2:
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 *
 * <p>Example 3:
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 * <p>Example 4:
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * 
 * <p>Note：
 * 1. {@code 1 <= A.length <= 10000}
 * 2. {@code 0 <= A[i] <= 9}
 * 3. {@code 0 <= K <= 10000}
 * 4. If {@code A.length > 1}, then {@code A[0] != 0}
 */
public class AddToArrayFormOfInteger {
  /**
   * Given the array form of an integer, adds a regular integer to it.
   *
   * @param a Integer in array form
   * @param k Integer in regular form
   * @return Sum of both integers in List form
   */
  public List<Integer> addToArrayForm(int[] a, int k) {
    Stack<Integer> top = toStack(a);
    Stack<Integer> bottom = toStack(k);

    return add(top, bottom);
  }

  private LinkedList<Integer> add(Stack<Integer> top, Stack<Integer> bottom) {
    LinkedList<Integer> addition = new LinkedList<>();
    int carryOver = 0;

    while (!top.empty() && !bottom.empty()) {
      Sum sum = new Sum(top.pop() + bottom.pop() + carryOver);
      addition.add(sum.getResult());
      carryOver = sum.getCarryOver();
    }
    while (!top.empty()) {
      Sum sum = new Sum(top.pop() + carryOver);
      addition.add(sum.getResult());
      carryOver = sum.getCarryOver();
    }
    while (!bottom.empty()) {
      Sum sum = new Sum(bottom.pop() + carryOver);
      addition.add(sum.getResult());
      carryOver = sum.getCarryOver();
    }
    if (carryOver > 0) {
      addition.add(carryOver);
      carryOver = 0;
    }
    Collections.reverse(addition);

    return addition;
  }

  private Stack<Integer> toStack(int[] ns) {
    Stack<Integer> stack = new Stack<Integer>();
    for (int n : ns) {
      stack.push(Integer.valueOf(n));
    }
    return stack;
  }

  private Stack<Integer> toStack(int n) {
    Stack<Integer> stack = new Stack<Integer>();
    while (n != 0) {
      int remainder = n % 10;
      stack.push(Integer.valueOf(remainder));
      n = n / 10;
    }
    Collections.reverse(stack);
    return stack;
  }

  private static class Sum {
    private int carryOver;
    private int result;

    public Sum(int sum) {
      this.carryOver = sum / 10;
      this.result = sum % 10;
    }

    public Sum(int carryOver, int result) {
      this.carryOver = carryOver;
      this.result = result;
    }

    public int getCarryOver() {
      return this.carryOver;
    }

    public int getResult() {
      return this.result;
    }

    public void setCarryOver(int carryOver) {
      this.carryOver = carryOver;
    }

    public void setResult(int result) {
      this.result = result;
    }
  }
}
