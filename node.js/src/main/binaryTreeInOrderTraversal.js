/**
 * 94. Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @param {TreeNode} root
 * @return {number[]}
 */
function inorderTraversalRecursive(root, acc) {
  if (acc == null) {
    acc = []
  }
  if (root == null) return acc

  inorderTraversalRecursive(root.left, acc)
  acc.push(root.val)
  inorderTraversalRecursive(root.right, acc)

  return acc
}
function inorderTraversalIterative(root) {
  let acc = []
  let stack = []
  let current = root

  while(current) {
    stack.push(Object.assign({}, current, { left: null}))
    current = current.left
  }
  while(stack.length > 0) {
    current = stack.pop()

    if (current.left) {
      stack.push(Object.assign({}, current, { left: null}))
      stack.push(current.left)
    } else {
      acc.push(current.val)
      if (current.right) {
        stack.push(current.right)
      }
    }
  }
  return acc
}

module.exports = {
  inorderTraversal: inorderTraversalIterative,
  inorderTraversalIterative,
  inorderTraversalRecursive
}
