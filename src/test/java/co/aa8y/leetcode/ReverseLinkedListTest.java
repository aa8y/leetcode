package co.aa8y.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import co.aa8y.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {
  private ReverseLinkedListIterative solutionIterative = new ReverseLinkedListIterative();
  private ReverseLinkedListRecursive solutionRecursive = new ReverseLinkedListRecursive();

  @Test
  public void testLeetCodeExample1() {
    ListNode head =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode expected =
        new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
    ListNode actualIterative = solutionIterative.reverseList(head);
    ListNode actualRecursive = solutionRecursive.reverseList(head);

    assertEquals(expected, actualIterative);
    assertEquals(expected, actualRecursive);
  }
}
