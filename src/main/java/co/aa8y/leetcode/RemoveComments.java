package co.aa8y.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a C++ program, remove comments from it. The program source is an array where source[i]
 * is the i-th line of the source code. This represents the result of splitting the original
 * source code string by the newline character \n.
 *
 * <p>In C++, there are two types of comments, line comments, and block comments.
 *
 * <p>The string // denotes a line comment, which represents that it and rest of the characters to
 * the right of it in the same line should be ignored.
 *
 * <p>The string /* denotes a block comment, which represents that all characters until the next
 * (non-overlapping) occurrence of <asterisk>/ should be ignored. (Here, occurrences happen in
 * reading order: line by line from left to right.) To be clear, the string /<asterisk>/ does
 * not yet end the block comment, as the ending would be overlapping the beginning.
 *
 * <p>The first effective comment takes precedence over others: if the string // occurs in a block
 * comment, it is ignored. Similarly, if the string /* occurs in a line or block comment, it is
 * also ignored.
 *
 * <p>If a certain line of code is empty after removing comments, you must not output that line:
 * each string in the answer list will be non-empty.
 *
 * <p>There will be no control characters, single quote, or double quote characters. For example,
 * source = "string s = "/* Not a comment. <asterisk>/";" will not be a test case. (Also, nothing
 * else such as defines or macros will interfere with the comments.)
 *
 * <p>It is guaranteed that every open block comment will eventually be closed, so /* outside of a
 * line or block comment always starts a new comment.
 *
 * <p>Finally, implicit newline characters can be deleted by block comments. Please see the examples
 * below for details.
 *
 * <p>After removing the comments from the source code, return the source code in the same format.
 *
 * <p>Note:
 * 1. The length of source is in the range [1, 100].
 * 2. The length of source[i] is in the range [0, 80].
 * 3. Every open block comment is eventually closed.
 * 4. There are no single-quote, double-quote, or control characters in the source code.
 */
public class RemoveComments {
  private static final Character NEWLINE = '\n';

  /**
   * The idea is to solve this as a state machine. We want to process a character at a time and
   * transition to different states based on the the character(s) we see.
   */
  public List<String> removeComments(String[] source) {
    List<Character> charSource = new LinkedList<Character>();

    // Convert the given source to a list of characters and introduce a newline after the end of
    // each line.
    for (String s : source) {
      for (char c : s.toCharArray()) {
        charSource.add(Character.valueOf(c));
      }
      charSource.add(Character.valueOf(NEWLINE));
    }

    List<Character> decommentedCharSource = codeState(charSource, new LinkedList<Character>());
    return toLines(decommentedCharSource);
  }

  /**
   * Code state is the initial state. This is where we keep the code and move on to the comment
   * or string state when we encounter a '/' or a '"' respectively. Here, the accumulator, 'acc'
   * contains all of the decommented code.
   *
   * While the question specifies that none of the test cases will have comments within a string,
   * I wanted to handle that case as well.
   */
  private List<Character> codeState(List<Character> source, List<Character> acc) {
    if (source.isEmpty()) {
      return acc;
    }
    Character head = getHead(source);
    List<Character> tail = getTail(source);

    if (head.equals('/')) {
      return commentState(tail, acc);
    } else if (head.equals('"')) {
      return stringState(tail, head, acc);
    } else {
      acc.add(head);
      return codeState(tail, acc);
    }
  }

  /**
   * The comment state redirects to either the single or multi line comment state based on whether
   * the next character is a '/' or a '*'. However, if it's neither, we go back to code state and
   * count the previous '/' as part of the code along with the current character we've read.
   */
  private List<Character> commentState(List<Character> source, List<Character> acc) {
    if (source.isEmpty()) {
      acc.add('/');
      return codeState(source, acc);
    }
    Character head = getHead(source);
    List<Character> tail = getTail(source);

    if (head.equals('/')) {
      return singleLineCommentState(tail, acc);
    } else if (head.equals('*')) {
      return multiLineCommentState(tail, new Stack<Character>(), acc);
    } else {
      acc.add('/');
      acc.add(head);
      return codeState(tail, acc);
    }
  }

  /**
   * This state's sole purpose is to drop everything till it encounters a newline. The newline is
   * retained so that cases such as '   // some comment  ' will result in '   ' as the returned
   * value.
   */
  private List<Character> singleLineCommentState(List<Character> source, List<Character> acc) {
    if (source.isEmpty()) {
      return codeState(source, acc);
    }
    Character head = getHead(source);
    List<Character> tail = getTail(source);

    if (head.equals(NEWLINE)) {
      acc.add(head);
      return codeState(tail, acc);
    }
    return singleLineCommentState(tail, acc);
  }

  /**
   * This state drops everything provided the multi-line comments end with a <asterisk>/. If that
   * doesn't happen and the source ends, all the characters stored in the 'prev' stack are added to
   * the accumulator in the correct order and returned to the code state.
   */
  private List<Character> multiLineCommentState(List<Character> source,
                                                Stack<Character> prev,
                                                List<Character> acc) {
    if (source.isEmpty()) {
      if (!prev.empty()) {
        Stack<Character> reversed = reverseStack(prev);
        while (!reversed.empty()) {
          acc.add(reversed.pop());
        }
      }
      return codeState(source, acc);
    }
    Character head = getHead(source);
    List<Character> tail = getTail(source);

    if (!prev.isEmpty() && prev.peek().equals('*') && head.equals('/')) {
      return codeState(tail, acc);
    }
    prev.push(head);
    return multiLineCommentState(tail, prev, acc);
  }

  private <T> Stack<T> reverseStack(Stack<T> stack) {
    Stack<T> reversed = new Stack<T>();
    while (!stack.empty()) {
      reversed.push(stack.pop());
    }
    return reversed;
  }

  /**
   * Retains everything between the double-quotes whether it's a comment or not.
   */
  private List<Character> stringState(List<Character> source, Character prev, List<Character> acc) {
    acc.add(prev);
    if (source.isEmpty() || prev.equals('"')) {
      return codeState(source, acc);
    }
    Character head = getHead(source);
    List<Character> tail = getTail(source);

    return stringState(tail, head, acc);
  }

  private <T> T getHead(List<T> ls) {
    return ls.get(0);
  }

  private <T> List<T> getTail(List<T> ls) {
    return ls.subList(1, ls.size());
  }

  /**
   * Converts the List of characters to a List of strings ignoring empty strings.
   */
  private List<String> toLines(List<Character> chars) {
    List<String> lines = new LinkedList<String>();
    StringBuilder sb = new StringBuilder();

    for (Character c : chars) {
      if (c.equals(NEWLINE)) {
        String s = sb.toString();
        if (!s.isEmpty()) {
          lines.add(s);
        }
        sb.setLength(0);
      } else {
        sb.append(c);
      }
    }

    return lines;
  }
}
