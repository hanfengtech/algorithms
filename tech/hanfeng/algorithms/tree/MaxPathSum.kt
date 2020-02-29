package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree
import kotlin.math.max

fun maxPathSum(root : TreeNode?) : Int {
    var maxValue = Int.MIN_VALUE

    fun helper(node : TreeNode?) : Int {
        if (node == null) return 0

        val left = max(0, helper(node.left))
        val right = max(0, helper(node.right))
        maxValue = max(maxValue, left + right + node.value)
        return max(left, right) + node.value
    }

    helper(root)
    return maxValue
}

fun main() {
    print(maxPathSum(populate123Tree()))
}