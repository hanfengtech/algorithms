package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.popoluateSymmetricTree
import tech.hanfeng.algorithms.tree.utils.populateTree

fun isSymmetric(root : TreeNode?) : Boolean {

    fun isMirror(p : TreeNode?, q: TreeNode?) : Boolean {
        if (p == null && q == null) return true

        if (p == null || q == null) return false

        if (p.value != q.value) return false

        return isMirror(p.left, q.right) && isMirror(p.right, q.left)
    }

    if (root == null) return true

    return isMirror(root.left, root.right)
}

fun main() {

    var tree = populateTree()
    println(isSymmetric(tree))
    tree = popoluateSymmetricTree()
    println(isSymmetric(tree))
}