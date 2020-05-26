package tech.hanfeng.algorithms.tree

import java.util.*
import kotlin.collections.ArrayList

data class Node(var value : Int = 0,  var left : Node? = null,  var right: Node? = null)

fun avgTreeLevel(root : Node?) : List<Int> {
    val resultList = ArrayList<Int>()
    if (root == null) {
        return resultList
    }

    val q = LinkedList<Node>()
    q.offer(root)

    while(q.isNotEmpty()) {
        val n = q.size
        var sum = 0
        for (i in 0 until n) {
            val cur = q.remove()
            sum += cur.value
            if (cur.left != null) {
                q.offer(cur.left)
            }
            if (cur.right != null) {
                q.offer(cur.right)
            }
        }
        resultList.add(sum / n)
    }

    return resultList
}

fun main() {
    val node = Node()
    node.value = 4

    node.left = Node(7)
    node.right = Node(9)

    println(avgTreeLevel(node))
}