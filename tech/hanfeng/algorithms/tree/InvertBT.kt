package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun invertTree(root : TreeNode?) : TreeNode? {
    if (root == null) return null

    val right = invertTree(root.right)
    root.right = invertTree(root.left)
    root.left = right

    return root
}

fun main() {
    val tree = populate123Tree()
    preorderPretty(tree)
    preorderPretty(invertTree(tree))
}