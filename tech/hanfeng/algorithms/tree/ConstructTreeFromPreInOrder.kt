package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val map = HashMap<Int, Int>()
    inorder.forEachIndexed { index, value -> map[value] = index }
    var curPreIndex = 0

    fun helper(inLeft : Int, inRight : Int) : TreeNode? {
        if (inLeft == inRight) return null
        val rootValue = preorder[curPreIndex++]
        return TreeNode(rootValue).apply {
            val rootIndex = map[value]!!
            left = helper(inLeft, rootIndex)
            right = helper(rootIndex + 1, inRight)
        }
    }

    return helper(0, inorder.size)
}

fun main() {
    preorderPretty(buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15, 20, 7)))
}