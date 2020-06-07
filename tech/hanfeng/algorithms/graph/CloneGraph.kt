package tech.hanfeng.algorithms.graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

data class Node(var `val` : Int, var neighbors : ArrayList<Node> = ArrayList())

class CloneGraph {

    private var visited = HashMap<Node, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return node

        if (visited.containsKey(node)) {
            return visited[node]
        }

        val cloneNode = Node(node.`val`)   // clone the node
        visited[node] = cloneNode

        for (neighbor in node.neighbors) {  // clone all neighbors of the node
            cloneNode.neighbors.add(cloneGraph(neighbor)!!)
        }
        return cloneNode
    }

    fun cloneGraphBFS(node: Node?) : Node? {
        if (node == null) return node

        var visited = HashMap<Node, Node>()

        var q = LinkedList<Node>()

        val cloneNode = Node(node.`val`)

        visited[node] = cloneNode

        q.offer(node)

        while(q.isNotEmpty()) {
            var n = q.remove()

            for (neighbor in n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited[neighbor] = Node(neighbor.`val`)
                    q.offer(neighbor)
                }
                visited[n]!!.neighbors.add(visited[neighbor]!!)
            }
        }

        return cloneNode
    }
}