package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import co.aa8y.leetcode.common.Side;
import co.aa8y.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

public class SmallestStringStartingFromLeafTest {
  private SmallestStringStartingFromLeaf solution = new SmallestStringStartingFromLeaf();

  @Test
  public void testLeetCodeExample1() {
    TreeNode root = new TreeNode(0,
        new TreeNode(1, new TreeNode(3), new TreeNode(4)),
        new TreeNode(2, new TreeNode(3), new TreeNode(4)));
    String expected = "dba";
    String actual = solution.smallestFromLeaf(root);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    TreeNode root = new TreeNode(25,
        new TreeNode(1, new TreeNode(1), new TreeNode(3)),
        new TreeNode(3, new TreeNode(0), new TreeNode(2)));
    String expected = "adz";
    String actual = solution.smallestFromLeaf(root);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample3() {
    TreeNode root = new TreeNode(2,
        new TreeNode(2,
          new TreeNode(1, new TreeNode(0), Side.LEFT),
          Side.RIGHT),
        new TreeNode(1, new TreeNode(0), Side.LEFT));
    String expected = "abc";
    String actual = solution.smallestFromLeaf(root);

    assertEquals(expected, actual);
  }
}
