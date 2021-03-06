package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree

fun isSameTree(p : TreeNode?, q : TreeNode?) : Boolean {
    if (p == null && q == null) return true

    if (p == null || q == null) return false

    if (p.value != q.value) return false

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}

fun main() {
    val p = populateTree()
    val q = populateTree()
    println(isSameTree(p,q))
}