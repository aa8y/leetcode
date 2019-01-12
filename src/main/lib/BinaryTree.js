/**
 * @param val Value of the node.
 * @param {TreeNode} left Left node of the Binary Tree.
 * @param {TreeNode} right Right node of the Binay Tree.
 */
function TreeNode(val, left, right) {
  this.val = val
  this.left = left || null
  this.right = right || null
}

module.exports = { TreeNode }
