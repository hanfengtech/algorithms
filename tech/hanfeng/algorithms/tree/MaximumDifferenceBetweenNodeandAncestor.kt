package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode

class MaximumDifferenceBetweenNodeandAncestor {

    fun maxAncestorDiffBF(root: TreeNode?): Int {
        var max = 0
        var ancestors = ArrayList<TreeNode>()

        fun dfs(node : TreeNode?, ancestors : ArrayList<TreeNode>) {

            if (node == null) return

            for (ancestor in ancestors) {
                max = maxOf(max, Math.abs(ancestor.`val` - node.`val`))
            }

            ancestors.add(node)
            dfs(node.left, ancestors)
            dfs(node.right, ancestors)
            ancestors.removeAt(ancestors.lastIndex)
        }

        dfs(root, ancestors)
        return max
    }


    fun maxAncestorDiff(root: TreeNode?): Int {
        var diff = 0

        fun dfs(node : TreeNode?, min : Int, max : Int)  {
            if (node == null) return

            val newMin = minOf(min, node.`val`)
            val newMax = maxOf(max, node.`val`)

            diff = maxOf(diff, newMax - newMin)

            dfs(node.left, newMin, newMax)
            dfs(node.right, newMax, newMin)
        }

        dfs(root, root!!.`val`, root!!.`val`)

        return diff
    }
}