package co.aa8y.leetcode.common;

/**
 * Definition for a binary tree node.
 *
 * <p>This is a pre-provided class by LeetCode which does not have any getters or setters. Since the
 * code in the repository is expected to be able to run in LeetCode with minimum modifications, no
 * gettes and setters have been added to this class and all variables have been left public.
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  /**
   * Represents a leaf node in a binary tree or a root node with no children.
   */
  public TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

  /**
   * Represents a node in a binary tree with both the left and right children.
   */
  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  /**
   * Represents a node in a binary tree with only one child denoted by the label.
   */
  public TreeNode(int val, TreeNode node, Side label) {
    this.val = val;
    if (label == Side.LEFT) {
      this.left = node;
      this.right = null;
    } else if (label == Side.RIGHT) {
      this.left = null;
      this.right = node;
    } else {
      this.left = null;
      this.right = null;
    }
  }
}
