const { assert } = require('chai')

const { TreeNode } = require('../main/lib/BinaryTree')

const { levelOrder } = require('../main/binaryTreeLevelOrderTraversal')

describe('102. Binary Tree Level Order Traversal', () => {
  describe('levelOrder()', () => {
    it('should return an empty array for a tree with a null root.', () => {
      const computed = levelOrder(null)
      const expected = []

      assert.isArray(computed)
      assert.deepEqual(computed, expected)
    })
    it('should traverse a two level tree.', () => {
      const root = new TreeNode(1, new TreeNode(2), new TreeNode(3))
      const computed = levelOrder(root)
      const expected = [[1], [2, 3]]

      assert.isArray(computed)
      assert.deepEqual(computed, expected)
    })
    it('should traverse an imbalanced tree with more nodes to the right.', () => {
      const root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))
      const computed = levelOrder(root)
      const expected = [[3], [9, 20], [15, 7]]

      assert.isArray(computed)
      assert.deepEqual(computed, expected)
    })
  })
  describe('LeetCode', () => {
    it('Test case #12', () => {
      const root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))
      const computed = levelOrder(root)
      const expected = [[1], [2, 3], [4, 5]]

      assert.isArray(computed)
      assert.deepEqual(computed, expected)
    })
    it('Test case #16', () => {
      const root = new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)))
      const computed = levelOrder(root)
      const expected = [[1], [2, 3], [4, 5]]

      assert.isArray(computed)
      assert.deepEqual(computed, expected)
    })
  })
})
