package co.aa8y.leetcode;

import co.aa8y.leetcode.common.Side;
import co.aa8y.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 *
 * <p>Given a binary tree, return the vertical order traversal of its nodes values.
 *
 * <p>For each node at position (x, y), its left and right children respectively will be at
 * positions (x-1, y-1) and (x+1, y-1).
 *
 * <p>Running a vertical line from x = -infinity to x = +infinity, whenever the vertical line
 * touches some nodes, we report the values of the nodes in order from top to bottom (decreasing y
 * coordinates).
 *
 * <p>If two nodes have the same position, then the value of the node that is reported first is the
 * value that is smaller.
 *
 * <p>Return an list of non-empty reports in order of X coordinate. Every report will have a list of
 * values of nodes.
 *
 * <p>Example 1:
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 *
 * <p>Example 2:
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * The node with value 5 and the node with value 6 have the same position according to the given
 * scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 *
 * <p>Note:
 * 1. The tree will have between 1 and 1000 nodes.
 * 2. Each node's value will be between 0 and 1000.
 */
public class VerticalOrderTraversalOfBinaryTree {
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<NodeLocation> locs = buildNodeLocations(root);
    return buildVerticalTraversal(locs);
  }

  private List<NodeLocation> buildNodeLocations(TreeNode node) {
    List<NodeLocation> locs = new ArrayList<>();
    locs.add(new NodeLocation(node, 0, 0));
    int i = 0;

    while (i < locs.size()) {
      NodeLocation next = locs.get(i);
      Optional<NodeLocation> left = next.buildLeftNodeLocation();
      Optional<NodeLocation> right = next.buildRightNodeLocation();

      if (left.isPresent()) {
        locs.add(left.get());
      }
      if (right.isPresent()) {
        locs.add(right.get());
      }
      i++;
    }
    return locs;
  }

  private List<List<Integer>> buildVerticalTraversal(List<NodeLocation> locs) {
    LinkedList<List<Integer>> traversed = new LinkedList<>();
    if (locs.isEmpty()) {
      return traversed;
    }
    sort(locs);
    // Seed initial values
    int currentX = locs.get(0).getX();
    traversed.push(new LinkedList<Integer>());

    // Traverse sorted locations
    for (NodeLocation loc : locs) {
      if (loc.getX() == currentX) {
        traversed.peek().add(loc.getValue());
      } else {
        LinkedList<Integer> newX = new LinkedList<>();
        newX.add(loc.getValue());
        // Use the LinkedList as a stack
        traversed.push(newX);
        // Update the value of current X
        currentX = loc.getX();
      }
    }
    // Reverse the stack
    Collections.reverse(traversed);
    return traversed;
  }

  private void sort(List<NodeLocation> locs) {
    Collections.sort(locs, new Comparator<NodeLocation>() {
      @Override
      public int compare(NodeLocation l, NodeLocation r) {
        if (l.getX() < r.getX()) {
          return -1;
        } else if (l.getX() > r.getX()) {
          return 1;
        } else {
          if (l.getY() > r.getY()) {
            return -1;
          } else if (l.getY() < r.getY()) {
            return 1;
          } else {
            return Integer.compare(l.getValue(), r.getValue());
          }
        }
      }
    });
  }

  private static class NodeLocation {
    private TreeNode node;
    // CHECKSTYLE:OFF x and y are appropriate co-ordinate variable names
    private int x;
    private int y;
    // CHECKSTYLE:ON

    public NodeLocation(TreeNode node, int x, int y) {
      this.node = node;
      this.x = x;
      this.y = y;
    }

    public TreeNode getNode() {
      return this.node;
    }

    public int getValue() {
      return this.node.val;
    }

    public int getX() {
      return this.x;
    }

    public int getY() {
      return this.y;
    }

    public void setNode(TreeNode node) {
      this.node = node;
    }

    public void setX(int x) {
      this.x = x;
    }

    public void setY(int y) {
      this.y = y;
    }

    public Optional<NodeLocation> buildLeftNodeLocation() {
      return buildNodeLocation(Side.LEFT);
    }

    public Optional<NodeLocation> buildRightNodeLocation() {
      return buildNodeLocation(Side.RIGHT);
    }

    private Optional<NodeLocation> buildNodeLocation(Side side) {
      if (side == Side.LEFT) {
        if (this.node.left == null) {
          return Optional.empty();
        }
        return Optional.of(new NodeLocation(this.node.left, x - 1, y - 1));
      } else {
        if (this.node.right == null) {
          return Optional.empty();
        }
        return Optional.of(new NodeLocation(this.node.right, x + 1, y - 1));
      }
    }
  }
}
