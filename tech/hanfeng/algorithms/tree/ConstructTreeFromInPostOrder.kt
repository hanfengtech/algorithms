package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty

/*
       inorder = [9,3,15,20,7]
       postorder = [9,15,7,20,3]
*/
fun buildTreeFromInPostorder(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (postorder.size != inorder.size)
        return null

    val map = HashMap<Int, Int>()

    inorder.forEachIndexed { index, value -> map[value] = index }

    fun helper(inStart : Int, inEnd : Int, postStart : Int, postEnd : Int) : TreeNode? {
        if (inStart > inEnd || postStart > postEnd) {
            return null
        }

        return TreeNode(postorder[postEnd]).apply {
            val rIndex = map[value]!!
            val numberOfLeftNodes = rIndex - inStart
            left = helper(inStart, rIndex - 1, postStart, postStart + numberOfLeftNodes - 1)
            right = helper(rIndex + 1, inEnd, postStart + numberOfLeftNodes, postEnd - 1)
        }
    }

    return helper(0, inorder.size - 1, 0, postorder.size - 1)
}

fun main() {
    preorderPretty(buildTreeFromInPostorder(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3)))
}