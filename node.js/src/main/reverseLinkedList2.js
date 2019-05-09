const { ListNode } = require('./lib/SinglyLinkedList')

/**
 * 92. Reverse Linked List II
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 *
 * @param {ListNode} head Head of the list.
 * @param {number} m Starting position from where it needs to be reversed.
 * @param {number} n Ending position from where it needs to be reversed.
 * @return {ListNode} Reversed list.
 */
function reverseBetween(head, m, n) {
  if (m >= n) return head

  let m1Head = m === 1 ? new ListNode(null, head) : head
  for (let i = 1; i < m - 1; i++) {
    m1Head = m1Head.next
  }
  let n1Head = head
  for (let i = 1; i < n - 1; i++) {
    n1Head = n1Head.next
  }
  let mHead = m1Head.next
  let nHead = n1Head.next

  m1Head.next = nHead
  n1Head.next = mHead

  let tmp = mHead.next
  mHead.next = nHead.next
  nHead.next = tmp

  return reverseBetween(head, m + 1, n - 1)
}

module.exports = { reverseBetween }
