const { assert } = require('chai')

const { ListNode } = require('../main/lib/SinglyLinkedList')

const { reverseBetween } = require('../main/reverseLinkedList2')

describe('092. Reverse Linked List II', () => {
  describe('reverseBetween()', () => {
    it('should return the same list for a list of size 1.', () => {
      const list = new ListNode(1)
      const computed = reverseBetween(list, 1, 1)

      assert.deepEqual(computed, list)
    })
    it('should return the same list if m and n are same.', () => {
      const list = new ListNode(1, new ListNode(2, new ListNode(3)))
      const computed = reverseBetween(list, 2, 2)

      assert.deepEqual(computed, list)
    })
    it('should reverse a small even sized list from m to n.', () => {
      const list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))
      const expected = new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(4))))
      const computed = reverseBetween(list, 2, 3)

      assert.deepEqual(computed, expected)
    })
    it('should reverse a small odd sized list from m to n.', () => {
      const list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
      const expected = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5)))))
      const computed = reverseBetween(list, 2, 4)

      assert.deepEqual(computed, expected)
    })
    it('should reverse a large even sized list from m to n.', () => {
      const list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))
      const expected = new ListNode(1, new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(6))))))
      const computed = reverseBetween(list, 2, 5)

      assert.deepEqual(computed, expected)
    })
    it('should reverse a large odd sized list from m to n.', () => {
      const list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))))
      const expected = new ListNode(1, new ListNode(6, new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(7)))))))
      const computed = reverseBetween(list, 2, 6)

      assert.deepEqual(computed, expected)
    })
    /*
    it('should be able to reverse a list completely, meaning m = 0 and n = list.length', () => {
      const list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))
      const expected = new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))
      const computed = reverseBetween(list, 1, 4)

      assert.deepEqual(computed, expected)
    })
    */
  })
  /*
  describe('LeetCode', () => {
    it('Test case #1', () => {
      const list = new ListNode(3, new ListNode(5))
      const expected = new ListNode(5, new ListNode(3))
      const computed = reverseBetween(list, 1, 2)

      assert.deepEqual(computed, expected)
    })
  })
  */
})
