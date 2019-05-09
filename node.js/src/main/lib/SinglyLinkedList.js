/**
 * @param val Value of the node.
 * @param {ListNode} next Next node of the Singly Linked List.
 */
function ListNode(val, next) {
  this.val = val
  this.next = next || null
}

module.exports = { ListNode }
