package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree

fun sumNumbers(root : TreeNode?) : Int {
    fun helper(node: TreeNode?, s : Int) : Int {
        if (node == null) return 0

        if (node.left == null && node.right == null) {
            return s * 10 + node.value
        }

        return helper(node.left, s * 10 + node.value) + helper(node.right, s * 10 + node.value)
    }

    return helper(root, 0)
}

fun main() {
    print(sumNumbers(populate123Tree()))
}