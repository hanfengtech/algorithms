package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun lowestCommonAncestorBT(root : TreeNode?, p : TreeNode, q : TreeNode) : TreeNode? {
    if (root == null || root == p || root == q) return root

    val left = lowestCommonAncestorBT(root.left, p, q)
    val right = lowestCommonAncestorBT(root.right, p, q)

    return if (left == null) {
        right
    } else {
        if (right == null) {
            left
        } else {
            root
        }
    }
}

fun main() {
    var node = TreeNode(1)
    node.left = TreeNode(2)
    node.left!!.left = TreeNode(4)
    node.left!!.right = TreeNode(5)
    node.right = TreeNode(3)

    node.right!!.left = TreeNode(6)
    node.right!!.right = TreeNode(7)

    node.left!!.left!!.left = TreeNode(8)

    node.left!!.left!!.right = TreeNode(9)
    node.left!!.right!!.left = TreeNode(10)
    node.left!!.right!!.right = TreeNode(11)

    node.right!!.left!!.left = TreeNode(12)

    preorderPretty(node)
    println(lowestCommonAncestorBT(node, node.left!!.left!!.left!!, node.left!!.right!!.right!! )!!.value)


    println(lowestCommonAncestorBT(node, node.left!!.left!!.left!!, node.right!!.left!!.left!! )!!.value)
}