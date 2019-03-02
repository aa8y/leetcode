package co.aa8y.leetcode;

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
public class LongestCommonPrefixLinear {
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
    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {
      prefix = longestCommonPrefix(prefix, strs[i]);
      if (prefix.isEmpty()) {
        return "";
      }
    }
    return prefix;
  }

  private String longestCommonPrefix(String l, String r) {
    return longestCommonPrefix(l.toCharArray(), r.toCharArray(), new StringBuilder(), 0);
  }

  private String longestCommonPrefix(char[] l, char[] r, StringBuilder sb, int i) {
    if (i >= l.length || i >= r.length) {
      return sb.toString();
    }
    if (l[i] == r[i]) {
      return longestCommonPrefix(l, r, sb.append(l[i]), ++i);
    }
    return sb.toString();
  }
}
