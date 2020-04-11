package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun diameterOfBinaryTree(root : TreeNode?) : Int {
    if (root == null) return 0
    var diameter = Integer.MIN_VALUE

    fun helper(node : TreeNode?) : Int {
        if (node == null) return 0

        val l = helper(node.left)
        val r = helper(node.right)

        diameter = Math.max(diameter, l + r + 1)

        return Math.max(l, r) + 1
    }

    helper(root)
    return diameter
}

fun main() {
    val tree = populate123Tree()
    preorderPretty(tree)
    println(diameterOfBinaryTree(tree))
}