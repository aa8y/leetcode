package co.aa8y.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 76. Minimum Window Substring
 *
 * <p>Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 *
 * <p>Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * <p>Note:
 * 1. If there is no such window in S that covers all characters in T, return the empty string "".
 * 2. If there is such window, you are guaranteed that there will always be only one unique minimum
 * window in S.
 */
public class MinimumWindowSubstring {
  private String substring = "";

  /**
   * Finds the shortest substring which has all the characters in the given target.
   *
   * @param s String in which the substring has to be found
   * @param t Target from which all the characters have to be present
   * @return Substring with all characters from the target
   */
  public String minWindow(String s, String t) {
    Set<Character> ts = IntStream.range(0, t.length())
                                 .mapToObj(t::charAt)
                                 .collect(Collectors.toSet());
    Queue<Window> q = new LinkedList<>();

    for (char c : s.toCharArray()) {
      Character curr = Character.valueOf(c);
      if (ts.contains(curr)) {
        q.add(new Window(t));
      }
      processQueue(q, curr);
    }
    return substring;
  }

  private void processQueue(Queue<Window> q, Character c) {
    int initSize = q.size();

    while (initSize-- > 0) {
      Window w = q.remove();
      w.addChar(c);
      if (w.isViable(substring)) {
        q.add(w);
      }
      if (!w.hasCapacity()) {
        String tmp = w.getSubstring();
        if (substring.isEmpty()) {
          substring = tmp;
        } else {
          substring = substring.length() > tmp.length() ? tmp : substring;
        }
      }
    }
  }

  private static class Window {
    private final StringBuilder substring;
    private final String target;
    private final Map<Character, Integer> targetFreq;

    public Window(String target) {
      this.substring = new StringBuilder();
      this.target = target;
      this.targetFreq = IntStream.range(0, target.length())
                                 .mapToObj(target::charAt)
                                 .collect(Collectors.toMap(x -> x, x -> 1, (x, y) -> x + y));
    }

    public void addChar(Character c) {
      if (targetFreq.containsKey(c)) {
        Integer freq = targetFreq.get(c) - 1;
        if (freq > 0) {
          targetFreq.put(c, freq);
        } else {
          targetFreq.remove(c);
        }
      }
      substring.append(c);
    }

    public boolean hasCapacity() {
      return !targetFreq.isEmpty();
    }

    public boolean isViable(String globalSubstring) {
      return hasCapacity() && (globalSubstring.isEmpty()
                           ||  substring.length() < globalSubstring.length());
    }

    public String getSubstring() {
      return substring.toString();
    }
  }
}
