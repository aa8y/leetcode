package co.aa8y.leetcode;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * <p>Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if
 * the input string is valid.
 *
 * <p>An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * <p>Example 1:
 * Input: "()"
 * Output: true
 *
 * <p>Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * <p>Example 3:
 * Input: "(]"
 * Output: false
 *
 * <p>Example 4:
 * Input: "([)]"
 * Output: false
 *
 * <p>Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
  private final Stack<Character> expectingNext = new Stack<>();

  /**
   * Determines if the given string of parentheses is valid or not.
   *
   * @param s String of parentheses
   * @return true if valid, else false
   */
  public boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    return isValid(s.toCharArray());
  }

  private boolean isValid(char[] cs) {
    for (char c : cs) {
      Character p = Character.valueOf(c);

      if (isOpen(p)) {
        expectingNext.push(getCorrespondingClosed(p));
      } else {
        if (expectingNext.empty()) {
          return false;
        }
        if (!p.equals(expectingNext.pop())) {
          return false;
        }
      }
    }
    return expectingNext.empty();
  }

  private Character getCorrespondingClosed(Character c) {
    switch (c) {
      case '(':
        return ')';
      case '{':
        return '}';
      default:
        return ']';
    }
  }

  private boolean isOpen(Character c) {
    switch (c) {
      case '(':
      case '{':
      case '[':
        return true;
      default:
        return false;
    }
  }
}
