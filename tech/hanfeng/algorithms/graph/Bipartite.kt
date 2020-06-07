package tech.hanfeng.algorithms.graph

import java.util.*

fun isBipartite(graph: Array<IntArray>): Boolean {
    val colors = IntArray(graph.size)

    fun dfs(i : Int, color : Int) : Boolean {
        if (colors[i] != 0) {          // already color
            return colors[i] == color
        } else {                       // not color
            colors[i] = color
            for (neighbor in graph[i]) {
                if (!dfs(neighbor, -color)) return false
            }
            return true
        }
    }

    for (i in graph.indices) {
        if (colors[i] == 0 && !dfs(i, 1)) {
            return false
        }
    }
    return true
}

fun isBipartiteIt(graph: Array<IntArray>): Boolean {
    val colors = IntArray(graph.size)
    for (i in graph.indices) {
        if (colors[i] == 0) {                // not color
            colors[i] = 1                    // color it
            val stack = LinkedList<Int>()    // stack to keep track of all vertice
            stack.push(i)

            while(stack.isNotEmpty()) {
                val node = stack.pop()
                for (neighbor in graph[node]) {
                    if (colors[neighbor] == 0) {  // not color
                        colors[neighbor] = -colors[node]  // color it with another color other than the node
                        stack.push(neighbor)
                    } else if (colors[neighbor] == colors[node]) {
                        return false
                    }
                }
            }
        }
    }
    return true
}


fun main() {
    val graph = arrayOf(intArrayOf(1,3),intArrayOf(0,2),intArrayOf(1,3),intArrayOf(0,2))
    println(isBipartiteIt(graph))
}



