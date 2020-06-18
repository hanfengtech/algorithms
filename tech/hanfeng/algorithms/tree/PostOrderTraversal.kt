package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class PostOrderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        var res = ArrayList<Int>()

        fun helper(node : TreeNode?) {
            if (node == null) return

            helper(node.left)
            helper(node.right)
            res.add(node.`val`)
        }

        helper(root)
        return res
    }

    fun postorderTraversalIT(root: TreeNode?): List<Int> {
        var res = LinkedList<Int>()

        if (root == null) return res

        val stack = LinkedList<TreeNode>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            var node = stack.pop()
            res.addFirst(node.`val`)
            if (node.left != null) {
                stack.push(node.left!!)
            }
            if (node.right != null) {
                stack.push(node.right!!)
            }
        }

        return res
    }
}