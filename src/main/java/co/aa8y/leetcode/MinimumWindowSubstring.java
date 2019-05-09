package co.aa8y.leetcode;

import java.util.HashMap;
import java.util.Map;
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
  /**
   * Finds the shortest substring which has all the characters in the given target.
   *
   * @param s String in which the substring has to be found
   * @param t Target from which all the characters have to be present
   * @return Substring with all characters from the target
   */
  public String minWindow(String s, String t) {
    int l = 0;
    int r = 0;
    char[] cs = s.toCharArray();
    String substring = "";
    Window w = new Window(t);

    while (l < cs.length || r < cs.length) {
      if (w.isDesirable()) {
        substring = getMinimumSubstring(substring, w.getSubstring());
        w.removeChar(cs[l++]);
        if (t.length() > 1) {
          while (true) {
            char c = cs[l];
            if (w.isTarget(c)) {
              break;
            }
            w.removeChar(c);
            l++;
          }
        }
      } else if (r < cs.length) {
        w.addChar(cs[r++]);
      } else if (l < cs.length) {
        w.removeChar(cs[l++]);
      }
    }
    return substring;
  }

  private String getMinimumSubstring(String currentSubstring, String newSubstring) {
    if (currentSubstring.isEmpty()) {
      return newSubstring;
    }
    return currentSubstring.length() > newSubstring.length() ? newSubstring : currentSubstring;
  }

  private static class Window {
    private final StringBuilder substring;
    private final String target;
    private final Map<Character, Integer> substringFreq;
    private final Map<Character, Integer> targetFreq;

    public Window(String target) {
      this.substring = new StringBuilder();
      this.substringFreq = new HashMap<>();
      this.target = target;
      this.targetFreq = IntStream.range(0, target.length())
                                 .mapToObj(target::charAt)
                                 .collect(Collectors.toMap(x -> x, x -> 1, (x, y) -> x + y));
    }

    public void addChar(Character c) {
      substringFreq.put(c, substringFreq.getOrDefault(c, 0) + 1);
      substring.append(c);
    }

    public String getSubstring() {
      return substring.toString();
    }

    public boolean isDesirable() {
      for (Map.Entry<Character, Integer> e : targetFreq.entrySet()) {
        Character key = e.getKey();
        if (!substringFreq.containsKey(key) || substringFreq.get(key) < e.getValue()) {
          return false;
        }
      }
      return true;
    }

    public boolean isTarget(Character c) {
      return targetFreq.containsKey(c);
    }

    public void removeChar(Character c) {
      Integer freq = substringFreq.get(c) - 1;
      if (freq > 0) {
        substringFreq.put(c, freq);
      } else {
        substringFreq.remove(c);
      }
      substring.deleteCharAt(substring.indexOf(c.toString()));
    }
  }
}
