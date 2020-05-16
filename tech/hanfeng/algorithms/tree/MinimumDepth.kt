package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import java.util.*

fun minDepth(root : TreeNode?) : Int {
    if (root == null) return 0

    val q = LinkedList<TreeNode>()
    q.offer(root)
    var depth = 0

    while(q.isNotEmpty()) {

        ++depth

        val count = q.size

        for (i in 0 until count) {
            val node = q.remove()

            if (node.left == null && node.right == null) return depth

            if (node.left != null) {
                q.offer(node.left!!)
            }

            if (node.right != null) {
                q.offer(node.right!!)
            }
        }
    }

    return depth
}

fun main() {
    println(minDepth(populateTree()))
    println(minDepth(TreeNode(10)))
}