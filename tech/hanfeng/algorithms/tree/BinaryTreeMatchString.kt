package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
    fun helper(node: TreeNode?, i : Int) : Boolean {
        if (node == null) {
            return i == 0
        }

        if (i == arr.size - 1) {
            return if (node.value == arr[i]) {
                node.left == null && node.right == null
            } else {
                false
            }
        }

        if (node.value != arr[i]) return false

        return helper(node.left, i + 1) || helper(node.right, i + 1)
    }

    return helper(root, 0)
}

fun main() {
    val tree = TreeNode(0)
    tree.left = TreeNode(1)
    tree.right = TreeNode(0)
    tree.left?.left = TreeNode(0)
    tree.right?.left = TreeNode(0)
    tree.left?.left?.right = TreeNode(1)
    tree.right?.left = TreeNode(0)

    preorderPretty(tree)

    println(isValidSequence(tree, intArrayOf(0,1,0,1)))
}

