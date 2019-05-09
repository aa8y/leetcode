package co.aa8y.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * 14. Longest Common Prefix
 *
 * <p>Write a function to find the longest common prefix string amongst an array of strings.
 *
 * <p>If there is no common prefix, return an empty string "".
 *
 * <p>Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * <p>Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * <p>Note:
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefixQuadratic {
  /**
   * Finds the longest common prefix between the given strings.
   *
   * @param strs List of strings
   * @return Longest common prefix
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    Arrays.sort(strs, new Comparator<String>() {
      @Override
      public int compare(String l, String r) {
        return l.length() - r.length();
      }
    });
    StringBuilder lcp = new StringBuilder();

    for (int i = 0; i < strs[0].length(); i++) {
      Optional<Character> prefix = Optional.empty();

      for (String str : strs) {
        Character c = Character.valueOf(str.charAt(i));
        prefix = prefix.isPresent() ? prefix : Optional.of(c);

        if (!prefix.get().equals(c)) {
          prefix = Optional.empty();
          break;
        }
      }
      if (prefix.isPresent()) {
        lcp.append(prefix.get());
      } else {
        break;
      }
    }
    return lcp.toString();
  }
}
