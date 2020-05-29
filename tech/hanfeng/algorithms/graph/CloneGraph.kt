package tech.hanfeng.algorithms.graph

class Node(var `val` : Int, var neighbors : ArrayList<Node> = ArrayList())

class CloneGraph {

    private var visited = HashMap<Node, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return node

        if (visited.containsKey(node)) {
            return visited[node]
        }

        val cloneNode = Node(node.`val`)
        visited[node] = cloneNode

        for (neighbor in node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor)!!)
        }
        return cloneNode
    }
}