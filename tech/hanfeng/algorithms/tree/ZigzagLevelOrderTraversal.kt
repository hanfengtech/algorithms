package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import java.util.*

fun zigzagLevelOrderTraversal(root: TreeNode?) : List<List<Int>> {
    val retList = LinkedList<LinkedList<Int>>()
    if (root == null) return retList

    val q = LinkedList<TreeNode>()
    q.add(root)
    var oddLevel = true

    while (q.isNotEmpty()) {
        val count = q.size
        val valList = LinkedList<Int>()

        for (i in 0 until count) {
            val node = q.remove()

            if (oddLevel) {
                valList.add(node.value)
            } else {
                valList.addFirst(node.value)
            }

            if (node.left != null) {
                q.add(node.left!!)
            }

            if (node.right != null) {
                q.add(node.right!!)
            }
        }
        retList.add(valList)
        oddLevel = !oddLevel
    }

    return retList
}

fun main() {
    print(zigzagLevelOrderTraversal(populateTree()))
}