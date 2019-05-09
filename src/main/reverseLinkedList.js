const { ListNode } = require('./lib/SinglyLinkedList')

/**
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * @param {ListNode} head Head of the list.
 * @param {ListNode} acc Optional accumulator parameter.
 * @return {ListNode} Reversed list.
 */
function reverseList(head, acc) {
  if (!head) return acc || null
  if (!acc) return reverseList(head.next, new ListNode(head.val))

  return reverseList(head.next, new ListNode(head.val, acc))
}
function reverseListMutated(head, acc) {
  if (!head) return acc || null
  if (!acc) {
    acc = new ListNode(head.val)
  } else {
    let tmp = new ListNode(head.val)
    tmp.next = acc
    acc = tmp
  }
  return reverseListMutated(head.next, acc)
}

module.exports = { reverseList, reverseListMutated }
