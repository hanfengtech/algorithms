package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*

class ClosestBinarySearchTreeValue {
    data class NodeInfo(var value : Int, var diff : Double)
    fun closestKValues(root: TreeNode?, target: Double, k: Int): List<Int>? {
        var q = PriorityQueue<NodeInfo>{ a, b -> (b.diff - a.diff).toInt() }

        fun dfs(node : TreeNode?) {
            if (node == null) return
            val diff = Math.abs(node.value - target)
            if (q.size == k) {
                if (diff < q.peek().diff) {
                    q.poll()
                    q.offer(NodeInfo(node.value, diff))
                }
            } else {
                q.offer(NodeInfo(node.value, diff))
            }
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)
        val res = ArrayList<Int>(q.size)
        while(q.isNotEmpty()) res.add(q.poll().value)
        return res
    }
}

fun main() {
    preorderPretty(populateTree())
    println(ClosestBinarySearchTreeValue().closestKValues(populateTree(), 28.789, 2)!!.joinToString())
}