const { assert } = require('chai')

const { TreeNode, convertBST } = require('../main/bstToGreaterTree')

describe('538. Convert BST to Greater Tree', () => {
  describe('convertBST()', () => {
    it('should return null for a null tree.', () => {
      assert.isNull(convertBST(null))
    })
    it('should BST to Greater tree.', () => {
      const bst = new TreeNode(5, new TreeNode(2), new TreeNode(13))
      const expected = new TreeNode(18, new TreeNode(20), new TreeNode(13))
      const computed = convertBST(bst)

      assert.deepEqual(computed, expected)
    })
  })
})
