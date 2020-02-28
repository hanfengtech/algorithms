package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import kotlin.math.max

fun maxDepth(root : TreeNode?) : Int {
    if (root == null) return 0
    return max(maxDepth(root.left), maxDepth(root.right)) + 1
}

fun main() {
    print(maxDepth(populateTree()))
}
