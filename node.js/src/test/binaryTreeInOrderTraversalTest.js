const { assert } = require('chai')

const { TreeNode } = require('../main/lib/BinaryTree')

const { inorderTraversalIterative, inorderTraversalRecursive } = require('../main/binaryTreeInOrderTraversal')

function check(tree, expected) {
  const computedI = inorderTraversalIterative(tree)
  const computedR = inorderTraversalRecursive(tree)

  assert.deepEqual(computedI, expected)
  assert.deepEqual(computedR, expected)
}
describe('094. Binary Tree Inorder Traversal', () => {
  describe('inorderTraversal()', () => {
    it('should return an empty array for a tree with a null root.', () => {
      check(null, [])
    })
    it('should return the node values in order for a balanced tree.', () => {
      const tree = new TreeNode(1, new TreeNode(2), new TreeNode(3))
      check(tree, [2, 1, 3])
    })
    it('should return the node values in order for a imbalanced tree.', () => {
      const tree = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))
      check(tree, [2, 1, 4, 3, 5])
    })
  })
  describe('LeetCode', () => {
    it('Test case #1', () => {
      const tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3)))
      check(tree, [1, 3, 2])
    })
  })
})
