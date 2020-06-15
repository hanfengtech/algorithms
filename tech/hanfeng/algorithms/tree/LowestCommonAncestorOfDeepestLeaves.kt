package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode

fun lcaDeepestLeaves(root : TreeNode?) : TreeNode? {
    var depth = 0
    var res : TreeNode? = null

    fun dfs(node : TreeNode?, cur : Int) : Int {
        if (node == null) {
            depth = maxOf(depth, cur)
            return cur
        }

        val left = dfs(node.left, cur + 1)
        val right = dfs(node.right, cur + 1)

        if (left == depth && right == depth) {
            res = node
        }
        return maxOf(left, right)
    }

    dfs(root, 0)
    return res
}