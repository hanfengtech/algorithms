package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree

var prevVal = Integer.MIN_VALUE

fun isValidateBST(root : TreeNode?) : Boolean {
    if (root == null) return true

    if (!isValidateBST(root.left)) return false

    // if left child which is the prev node value greater than curr value, return false
    if (prevVal >= root.value) return false

    prevVal = root.value

    return isValidateBST(root.right)
}

fun main() {
    val tree = populateTree()
    print(isValidateBST(tree))
}