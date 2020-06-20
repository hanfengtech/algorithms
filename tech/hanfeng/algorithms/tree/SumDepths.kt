package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode

fun findSumDepths(root : TreeNode) : Int {
    var ans = 0

    fun dfs(n : TreeNode, depth : Int) {
        if (n == null) return

        ans += depth
        dfs(n.left, depth + 1)
        dfs(n.right, depth + 1)
    }

    dfs(root, 0)
    return ans
}