package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null) return t2
    if (t2 == null) return t1

    t1.value += t2.value

    if (t1.left != null) {
        mergeTrees(t1.left, t2.left)
    } else {
        t1.left = t2.left
    }

    if (t1.right != null) {
        mergeTrees(t1.right, t2.right)
    } else {
        t1.right = t2.right
    }

    return t1
}

fun main() {
    val t1 = populate123Tree()
    val t2 = populateTree()

    println("Tree 1")
    preorderPretty(t1)
    println("Tree 2")
    preorderPretty(t2)
    println("Merged tree")
    preorderPretty(mergeTrees(t1,t2))
}