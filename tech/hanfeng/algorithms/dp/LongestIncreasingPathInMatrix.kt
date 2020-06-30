package tech.hanfeng.algorithms.dp

import tech.hanfeng.algorithms.array.util.printMatrix

class LongestIncreasingPathInMatrix {
    data class Location(var x : Int, var y : Int)
    var directions = arrayOf(Location(0,1), Location(0,-1), Location(1,0), Location(-1,0))
    private var max = 0
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
        val lengths = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                findLongestPath(matrix, lengths, i, j, Int.MIN_VALUE)
        printMatrix(lengths)
        return max
    }

    private fun findLongestPath(matrix: Array<IntArray>, lengths: Array<IntArray>, i: Int, j: Int, prev: Int): Int {
        if (i < 0 || i >= matrix.size || j < 0 || j >= matrix[0].size) return 0
        if (matrix[i][j] <= prev) return 0
        if (lengths[i][j] > 0) return lengths[i][j]
        var localMax = 0
        for ( (dx, dy) in directions)
            localMax = maxOf(localMax, findLongestPath(matrix, lengths, i + dx, j + dy, matrix[i][j]))

        lengths[i][j] = localMax + 1
        max = maxOf(max, lengths[i][j])
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

    matrix = arrayOf(intArrayOf(
            1,1,1), intArrayOf(
            1,1,1), intArrayOf(
            1,1,1))
    println(sol.longestIncreasingPath(matrix))
}