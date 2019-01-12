const { assert } = require('chai')

const { ListNode } = require('../main/lib/SinglyLinkedList')

const { reverseList, reverseListMutated } = require('../main/reverseLinkedList')

function check(list, expected) {
  const computed1 = reverseList(list)
  const computed2 = reverseListMutated(list)

  assert.deepEqual(computed1, expected)
  assert.deepEqual(computed2, expected)
}
describe('206. Reverse Linked List', () => {
  describe('reverseList()', () => {
    it('should return null for a null list.', () => {
      check(null, null)
    })
    it('should return the same list for a list of size 1.', () => {
      const list = new ListNode(1)
      check(list, list)
    })
    it('should reverse a given list.', () => {
      const list = new ListNode(1, new ListNode(2, new ListNode(3)))
      const expected = new ListNode(3, new ListNode(2, new ListNode(1)))
      check(list, expected)
    })
  })
  describe('LeetCode', () => {
    it('Test case #3', () => {
      const list = new ListNode(1, new ListNode(2))
      const expected = new ListNode(2, new ListNode(1))
      check(list, expected)
    })
  })
})
