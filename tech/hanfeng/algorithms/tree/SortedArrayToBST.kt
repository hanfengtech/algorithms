package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun sortedArrayToBST(nums : IntArray) : TreeNode? {
    if (nums.isEmpty()) return null

    fun constructBST(nums : IntArray, low : Int, high : Int) : TreeNode? {
        var node : TreeNode? = null

        if (low < high) {
            var mid = (low + high) / 2
            node = TreeNode(nums[mid])

            node.left = constructBST(nums, low, mid)
            node.right = constructBST(nums, mid + 1, high)
        }
        return node
    }

    return constructBST(nums, 0, nums.size)
}

fun main() {
    preorderPretty(sortedArrayToBST(intArrayOf(2,4,6,8,10,12,14)))
}