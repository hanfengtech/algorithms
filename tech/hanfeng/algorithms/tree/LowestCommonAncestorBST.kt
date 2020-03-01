package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun lowestCommonAncestor(root : TreeNode?, p : TreeNode, q : TreeNode) : TreeNode? {

    if (root == null) return null

    return if ( (root.value - p.value) * (root.value - q.value) < 1) {
        root
    } else {
        lowestCommonAncestor( if (p.value < root.value) root.left else root.right, p, q)
    }
}

fun main() {
    val tree = populateTree()
    preorderPretty(lowestCommonAncestor(tree, TreeNode(54), TreeNode(93)))
}

