const { assert } = require('chai')

const { ListNode } = require('../main/lib/SinglyLinkedList')

const { reverseList } = require('../main/reverseLinkedList')

describe('206. Reverse Linked List', () => {
  describe('reverseList()', () => {
    it('should return null for a null list.', () => {
      const computed = reverseList(null)

      assert.isNull(computed)
    })
    it('should return the same list for a list of size 1.', () => {
      const list = new ListNode(1)
      const computed = reverseList(list)

      assert.deepEqual(computed, list)
    })
    it('should reverse a given list.', () => {
      const list = new ListNode(1, new ListNode(2, new ListNode(3)))
      const computed = reverseList(list)
      const expected = new ListNode(3, new ListNode(2, new ListNode(1)))

      assert.deepEqual(computed, expected)
    })
  })
})
