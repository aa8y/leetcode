/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to
 * right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @param {TreeNode} root
 * @return {number[][]}
 */
function levelOrder(root, level, queue, acc) {
  if (level == null) {
    level = 0
  }
  if (queue == null) {
    queue = []
  }
  if (acc == null) {
    acc = []
  }
  if (root == null) return acc
  if (level === 0) {
    acc.push([root.val])
  } else {
    acc[level].push(root.val)
  }
  if (root.left && root.right) {
    queue.push([root.left, root.right])
  } else if (root.left) {
    queue.push([root.left])
  } else if (root.right) {
    queue.push([root.right])
  }
  while(queue.length > 0) {
    level += 1
    const levelQueue = queue.shift()
    if (acc[level] == null) {
      acc.push([])
    }
    while(levelQueue.length > 0) {
      const next = levelQueue.shift()
      levelOrder(next, level, queue, acc)
    }
  }
  return acc
}

module.exports = { levelOrder }
