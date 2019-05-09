package co.aa8y.leetcode;

import co.aa8y.leetcode.common.ListNode;

/**
 * 206. Reverse Linked List
 *
 * <p>Reverse a singly linked list.
 *
 * <p>Example:
 * Input: {@code 1->2->3->4->5->NULL}
 * Output: {@code 5->4->3->2->1->NULL}
 *
 * <p>Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
class ReverseLinkedListIterative {
  /**
   * Reverses the given Linked list recusively.
   *
   * @param head Head node of the linked list
   * @return Head node of the reversed linked list
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode reversed = new ListNode(head.val);

    while (head.next != null) {
      ListNode newReversed = new ListNode(head.next.val);
      newReversed.next = reversed;
      reversed = newReversed;
      head = head.next;
    }
    return reversed;
  }
}
