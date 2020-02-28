package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree

fun bstMax(root : TreeNode?) : Int {

    if (root == null) return Int.MAX_VALUE

    var cur = root

    while(cur!!.right != null) {
        cur = cur.right
    }

    return cur.value
}

fun main() {
    var tree : TreeNode?
    tree = populateTree()
    println(bstMax(tree))
    println(bstMax(TreeNode(1)))
    tree = null
    println(bstMax(tree))
}