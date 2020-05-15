package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

    fun helper(preStart : Int, inStart : Int, inEnd : Int) : TreeNode? {
        if (preStart > preorder.size - 1 || inStart > inEnd) {
            return null
        }

        var root = TreeNode(preorder[preStart])

        var inIndex = 0
        for (i in inStart .. inEnd) {
            if (inorder[i] == root.value) {
                inIndex = i
                break
            }
        }

        // left subtree
        root.left = helper(preStart + 1, inStart, inIndex - 1)

        // right subtree
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd)

        return root
    }

    return helper(0, 0, inorder.size - 1)
}

fun main() {
    preorderPretty(buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15, 20, 7)))
}