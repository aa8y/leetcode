package co.aa8y.leetcode;

import co.aa8y.leetcode.common.TreeNode;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 988. Smallest String Starting From Leaf
 *
 * <p>Given the root of a binary tree, each node has a value from 0 to 25 representing the letters i
 * 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 *
 * <p>Find the lexicographically smallest string that starts at a leaf of this tree and ends at the
 * root.
 *
 * <p>(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab"
 * is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 *
 * <p>Example 1:
 * Input: [0,1,2,3,4,3,4]
 * Output: "dba"
 *
 * <p>Example 2:
 * Input: [25,1,3,1,3,0,2]
 * Output: "adz"
 *
 * <p>Example 3:
 * Input: [2,2,1,null,1,0,null,0]
 * Output: "abc"
 *
 * <p>Note:
 * 1. The number of nodes in the given tree will be between 1 and 1000.
 * 2. Each node in the tree will have a value between 0 and 25.
 */
public class SmallestStringStartingFromLeaf {
  private final SortedSet<String> strs = new TreeSet<>();
  private final Stack<Node> stack = new Stack<>();

  /**
   * Returns the smallest string, lexicographically, from the leaf of the given tree.
   *
   * @param root Root of the tree
   */
  public String smallestFromLeaf(TreeNode root) {
    if (root == null) {
      return "";
    }
    stack.push(new Node(root, Label.TRAVERSE));
    dfsPostorder(new StringBuilder());

    return strs.first();
  }

  private void dfsPostorder(StringBuilder sb) {
    while (!stack.isEmpty()) {
      Node next = stack.pop();

      if (next.label == Label.DELETE) {
        sb.delete(sb.length() - 1, sb.length());
      }
      if (next.label == Label.TRAVERSE) {
        if (!isLeaf(next.node)) {
          stack.push(new Node(next.node, Label.DELETE));

          if (next.node.right != null) {
            stack.push(new Node(next.node.right, Label.TRAVERSE));
          }
          if (next.node.left != null) {
            stack.push(new Node(next.node.left, Label.TRAVERSE));
          }
        }
        sb.append(toChar(next.node.val));

        if (isLeaf(next.node)) {
          sb.reverse();
          strs.add(sb.toString());
          sb.reverse();

          stack.push(new Node(next.node, Label.DELETE));
        }
      }
    }
  }

  private boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }

  private char toChar(int val) {
    return (char) ('a' + val);
  }

  private class Node {
    TreeNode node;
    Label label;

    Node(TreeNode node, Label label) {
      this.node = node;
      this.label = label;
    }
  }

  protected static enum Label {
    DELETE,
    TRAVERSE
  }
}
