package tech.hanfeng.algorithms.graph

    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val graph = Array(N) { ArrayList<Int>() }
        val colors = IntArray(N)

        for (edge in dislikes) {       // create adj list
            graph[edge[0] - 1].add(edge[1] - 1)
            graph[edge[1] - 1].add(edge[0] - 1)
        }

        // do the is biparition
        fun dfs(node : Int, color : Int) : Boolean {
            if (colors[node] == 0) {   // not color yet
                colors[node] = color

                for(neighbor in graph[node]) {
                    if (!dfs(neighbor, -color)) {
                        return false
                    }
                }
            } else {                   // colored
                return colors[node] == color
            }
            return true
        }

        for (node in 0 until N)
            if (colors[node] == 0 && !dfs(node, 1)) return false
        return true
    }

fun main() {
    println(possibleBipartition(4, arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,4))))

}