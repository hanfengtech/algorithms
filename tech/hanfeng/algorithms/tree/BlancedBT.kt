package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateBalancedTree
import tech.hanfeng.algorithms.tree.utils.populateTree
import kotlin.math.abs
import kotlin.math.max

const val UNBALANCED = -1

fun isBalanced(root : TreeNode?) : Boolean {
    fun absHeight(node : TreeNode?) : Int {
        if (node == null) return 0

        if (node.left == null && node.right == null) return 1

        val left = absHeight(node.left)

        if (left == UNBALANCED) return UNBALANCED

        val right = absHeight(node.right)

        if (right == UNBALANCED) return UNBALANCED

        if (abs(left - right) > 1) return UNBALANCED

        return max(left, right) + 1
    }

    return absHeight(root) != -1
}

fun main() {
    println(isBalanced(populateTree()))
    println(isBalanced(populateBalancedTree()))
}