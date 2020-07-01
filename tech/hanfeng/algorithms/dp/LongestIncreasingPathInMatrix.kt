package tech.hanfeng.algorithms.dp

class LongestIncreasingPathInMatrix {
    data class Location(var x : Int, var y : Int)
    private var directions = arrayOf(Location(0,1), Location(0,-1), Location(1,0), Location(-1,0))
    private var max = 0
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
        val lengths = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                findLongestPath(matrix, lengths, i, j, Int.MIN_VALUE)
        return max
    }

    private fun findLongestPath(matrix: Array<IntArray>, lengths: Array<IntArray>, i: Int, j: Int, prev: Int): Int {
        if (i < 0 || i >= matrix.size || j < 0 || j >= matrix[0].size) return 0
        if (matrix[i][j] <= prev) return 0                  // if the current value less than previous value, don't do anything
        if (lengths[i][j] > 0) return lengths[i][j]         // if there is already a lengths, just return the length
        var localMax = 0
        for ( (dx, dy) in directions)                       // for each directions dfs to get maximum length
            localMax = maxOf(localMax, findLongestPath(matrix, lengths, i + dx, j + dy, matrix[i][j]))
        lengths[i][j] = localMax + 1                        // record the length
        max = maxOf(max, lengths[i][j])                     // update the max
        return lengths[i][j]
    }
}

fun main() {
    var sol = LongestIncreasingPathInMatrix()

    var matrix = arrayOf(intArrayOf(
            9,9,4), intArrayOf(
            6,6,8), intArrayOf(
            2,1,1))

    println(sol.longestIncreasingPath(matrix))
}