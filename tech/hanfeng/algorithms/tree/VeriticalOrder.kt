package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateCompleteTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*
import kotlin.collections.ArrayList

fun verticalOrder(root : TreeNode?) : List<List<Int>> {
    val results = ArrayList<ArrayList<Int>>()

    if (root == null) return results

    val columnTable = HashMap<Int, ArrayList<Int>>()
    val q = LinkedList<Pair<TreeNode?, Int>>()
    var col = 0
    q.offer(Pair(root, col))
    var minCol = 0
    var maxCol = 0

    while(q.isNotEmpty()) {
        val pair = q.poll()
        val node = pair.first
        col = pair.second

        if (node != null) {
            columnTable.getOrPut(col, { ArrayList() }).add(node.value)
            minCol = Math.min(minCol, col)
            maxCol = Math.max(maxCol, col)

            q.offer(Pair(node.left, col - 1))
            q.offer(Pair(node.right, col + 1))
        }
    }

    for (i in minCol .. maxCol) {
        results.add(columnTable[i]!!)
    }

    return results
}

fun main() {
    var t = populateCompleteTree()
    preorderPretty(t)

    t = populateCompleteTree()
    val results = verticalOrder(t)

    results.forEach {
        println(it.joinToString())
    }
}