package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? {
    if (pre.size != post.size) return null
    val map = HashMap<Int, Int>()
    post.forEachIndexed { index, value ->  map[value] = index }

    fun helper(preI : Int, postI : Int, size : Int) : TreeNode? {
        if (size == 0) return null
        var root = TreeNode(pre[preI])

        if (size == 1) return root

        val leftTreeSize = map[pre[preI + 1]]!! - postI + 1

        root.left = helper(preI + 1, postI, leftTreeSize)
        root.right = helper(preI + leftTreeSize + 1, postI + leftTreeSize, size - 1 - leftTreeSize)

        return root
    }

    return helper(0, 0, pre.size)
}

fun main() {
    preorderPretty(constructFromPrePost(intArrayOf(1,2,4,5,3,6,7), intArrayOf(4,5,2,6,7,3,1)))
}