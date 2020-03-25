package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty

var prevVal = Integer.MIN_VALUE

// In-order travels and remember the previous node value
fun isValidateBST(root : TreeNode?) : Boolean {
    if (root == null) return true

    if (!isValidateBST(root.left)) return false

    // if left child which is the prev node value greater than curr value, return false
    if (prevVal >= root.value) return false

    prevVal = root.value

    return isValidateBST(root.right)
}

fun main() {
   // val tree = populateTree()
   // println(isValidateBST(tree))


    var node = TreeNode(5)
    node.left = TreeNode(2)
    node.left!!.left = TreeNode(1)
    node.left!!.right = TreeNode(3)
    node.right = TreeNode(6)
    node.right!!.left = TreeNode(4)
    node.right!!.right = TreeNode(7)

    preorderPretty(node)
    println(isValidateBST(node))

    node = TreeNode(5)
    node.left = TreeNode(1)
    node.right = TreeNode(6)
    node.right!!.left = TreeNode(7)
    node.right!!.right = TreeNode(8)

    preorderPretty(node)
    println(isValidateBST(node))
}