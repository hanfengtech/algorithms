package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import java.util.*

fun levelOrder(root : TreeNode?) : List<List<Int>> {
    var retList = LinkedList<LinkedList<Int>>()

    if (root == null) return retList

    val q = LinkedList<TreeNode>()
    q.add(root)

    while(q.isNotEmpty()) {
        val count = q.size
        val valList = LinkedList<Int>()

        for (i in 0 until count) {
            val node = q.remove()
            valList.add(node.value)

            if (node.left != null) {
                q.add(node.left!!)
            }
            if (node.right != null) {
                q.add(node.right!!)
            }
        }

        retList.add(valList)
    }

    return retList
}

fun main() {
    val tree = populateTree()
    print(levelOrder(tree))
}