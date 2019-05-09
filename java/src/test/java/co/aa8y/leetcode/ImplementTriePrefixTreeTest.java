package co.aa8y.leetcode;

import static co.aa8y.leetcode.ImplementTriePrefixTree.Trie;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ImplementTriePrefixTreeTest {

  @Test
  public void testLeetCodeExample1() {
    Trie trie = new Trie();

    trie.insert("apple");
    assertEquals(true, trie.search("apple"));
    assertEquals(false, trie.search("app"));
    assertEquals(true, trie.startsWith("app"));
    trie.insert("app");
    assertEquals(true, trie.search("app"));
  }

  @Test
  public void testLeetCodeTestCase12() {
    Trie trie = new Trie();

    trie.insert("app");
    trie.insert("apple");
    trie.insert("beer");
    trie.insert("add");
    trie.insert("jam");
    trie.insert("rental");
    assertEquals(false, trie.search("apps"));
    assertEquals(true, trie.search("app"));
    assertEquals(false, trie.search("ad"));
    assertEquals(false, trie.search("applepie"));
    assertEquals(false, trie.search("rest"));
    assertEquals(false, trie.search("jan"));
    assertEquals(false, trie.search("rent"));
    assertEquals(true, trie.search("beer"));
    assertEquals(true, trie.search("jam"));
    assertEquals(false, trie.startsWith("apps"));
    assertEquals(true, trie.startsWith("app"));
    assertEquals(true, trie.startsWith("ad"));
    assertEquals(false, trie.startsWith("applepie"));
    assertEquals(false, trie.startsWith("rest"));
    assertEquals(false, trie.startsWith("jan"));
    assertEquals(true, trie.startsWith("rent"));
    assertEquals(true, trie.startsWith("beer"));
    assertEquals(true, trie.startsWith("jam"));
  }
}
