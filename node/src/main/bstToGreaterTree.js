/**
 * 538. Convert BST to Greater Tree
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the 
 * original BST is changed to the original key plus sum of all keys greater than the original key 
 * in BST.
 *
 * Example:
 *   Input: The root of a Binary Search Tree like this:
 *                 5
 *               /   \
 *              2     13
 *   Output: The root of a Greater Tree like this:
 *                18
 *               /   \
 *             20     13
 */

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

/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
function convertBST(root) {
  function convert(root, acc) {
    if (root == null) return { node: root, acc }

    const right = convert(root.right, acc)
    root.right = right.node
    acc = right.acc

    acc += root.val
    root.val = acc

    const left = convert(root.left, acc)
    root.left = left.node
    acc = left.acc

    return { node: root, acc }
  }
  return convert(root, 0).node
}

module.exports = { TreeNode, convertBST }
