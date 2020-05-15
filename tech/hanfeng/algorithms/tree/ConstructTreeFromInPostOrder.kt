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

    fun helper(inStart : Int, inEnd : Int, postEnd : Int) : TreeNode? {
        if (inStart > inEnd) {
            return null
        }

        return TreeNode(postorder[postEnd]).apply {
            val rootIndex = map[value]!!
            right = helper(rootIndex + 1, inEnd, postEnd - 1)
            left = helper(inStart, rootIndex - 1, postEnd + rootIndex - inEnd - 1)
        }
    }

    return helper(0, inorder.size - 1,postorder.size - 1)
}

fun main() {
    preorderPretty(buildTreeFromInPostorder(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3)))
}