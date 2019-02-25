package co.aa8y.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 208. Implement Trie (Prefix Tree)
 *
 * <p>Implement a trie with insert, search, and startsWith methods.
 *
 * <p>Example:
 * <pre>
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * </pre>
 *
 * <p>Note:
 * 1. You may assume that all inputs are consist of lowercase letters a-z.
 * 2. All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTriePrefixTree {
  static class Trie {
    private final TrieNode root = new TrieNode();

    public Trie() { }

    /**
     * Inserts a word into the trie.
     *
     * @param word Word to be stored in the Trie
     */
    public void insert(String word) {
      TrieNode next = root;
      for (char c : word.toCharArray()) {
        next = next.getOrCreateChild(Character.valueOf(c));
      }
      next.isCompleteWord(true);
    }

    /**
     * Returns if the word is in the trie.
     *
     * @param word Word to be searched for
     * @return true if present, else false
     */
    public boolean search(String word) {
      Optional<TrieNode> node = searchPrefix(word);
      if (node.isPresent()) {
        return node.get().isCompleteWord();
      }
      return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     *
     * @param prefix Prefix to be searched for
     * @return true if present, else false
     */
    public boolean startsWith(String prefix) {
      return searchPrefix(prefix).isPresent();
    }

    private Optional<TrieNode> searchPrefix(String prefix) {
      TrieNode next = root;
      for (char c : prefix.toCharArray()) {
        Optional<TrieNode> node = next.getChild(Character.valueOf(c));

        if (node.isPresent()) {
          next = node.get();
        } else {
          return node;
        }
      }
      return Optional.of(next);
    }
  }

  static class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isCompleteWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.isCompleteWord = false;
    }

    public Optional<TrieNode> getChild(Character child) {
      if (children.containsKey(child)) {
        return Optional.of(children.get(child));
      }
      return Optional.<TrieNode>empty();
    }

    public TrieNode getOrCreateChild(Character child) {
      Optional<TrieNode> node = getChild(child);
      if (node.isPresent()) {
        return node.get();
      }
      return createChild(child);
    }

    public boolean isCompleteWord() {
      return this.isCompleteWord;
    }

    public boolean isCompleteWord(boolean isCompleteWord) {
      this.isCompleteWord = isCompleteWord;
      return this.isCompleteWord;
    }

    private TrieNode createChild(Character child) {
      TrieNode node = new TrieNode();
      children.put(child, node);
      return node;
    }
  }
}
