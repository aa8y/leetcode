package co.aa8y.leetcode;

import static co.aa8y.leetcode.ImplementTriePrefixTree.TrieNode;

import java.util.Map;

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
public class LongestCommonPrefixTrie {
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
    Trie trie = new Trie();

    for (String str : strs) {
      trie.insert(str);
    }
    return trie.longestCommonPrefix();
  }

  static class Trie {
    private final TrieNode root = new TrieNode();

    public Trie() { }

    public void insert(String word) {
      TrieNode next = root;
      for (char c : word.toCharArray()) {
        next = next.getOrCreateChild(Character.valueOf(c));
      }
      next.isCompleteWord(true);
    }

    public String longestCommonPrefix() {
      TrieNode next = root;
      Map<Character, TrieNode> children = next.getChildren();
      StringBuilder lcp = new StringBuilder();

      while (children.size() == 1 && !next.isCompleteWord()) {
        Map.Entry<Character, TrieNode> e = children.entrySet().iterator().next();
        lcp.append(e.getKey());
        next = e.getValue();
        children = next.getChildren();
      }
      return lcp.toString();
    }
  }
}
