package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import co.aa8y.leetcode.common.Side;
import co.aa8y.leetcode.common.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class VerticalOrderTraversalOfBinaryTreeTest {
  private VerticalOrderTraversalOfBinaryTree solution = new VerticalOrderTraversalOfBinaryTree();

  @Test
  public void testLeetCodeExample1() {
    TreeNode root = new TreeNode(3,
        new TreeNode(9),
        new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(9),
        Arrays.asList(3, 15),
        Arrays.asList(20),
        Arrays.asList(7)
    );
    List<List<Integer>> actual = solution.verticalTraversal(root);

    assertEquals(expected, actual);
  }

  @Test
  public void testLeetCodeExample2() {
    TreeNode root = new TreeNode(1,
        new TreeNode(2, new TreeNode(4), new TreeNode(5)),
        new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(4),
        Arrays.asList(2),
        Arrays.asList(1, 5, 6),
        Arrays.asList(3),
        Arrays.asList(7)
    );
    List<List<Integer>> actual = solution.verticalTraversal(root);

    assertEquals(expected, actual);
  }
}
