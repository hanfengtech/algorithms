package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree

fun bstMin(root : TreeNode?) : Int {
    if (root == null) return Int.MIN_VALUE
    var cur = root

    while (cur!!.left != null) {
        cur = cur.left
    }

    return cur.value
}

fun main(){
    var tree : TreeNode?
    tree = populateTree()
    println(bstMin(tree))
    println(bstMin(TreeNode(21)))
    tree = null
    println(bstMin(tree))
}