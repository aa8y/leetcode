package co.aa8y.leetcode.common;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
    this.next = null;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    ListNode that = (ListNode) obj;
    return this.val == that.val
        && ((this.next == null && that.next == null) || this.next.equals(that.next));
  }

  @Override
  public String toString() {
    return this.val + " -> " + (this.next == null ? "NULL" : next.toString());
  }
}
