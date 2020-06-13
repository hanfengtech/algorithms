package tech.hanfeng.algorithms.matrix

fun islandPerimeter(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size

    var result = 0
    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == 1) {
                result += 4

                if (r > 0 && grid[r - 1][c] == 1) {
                    result -= 2
                }

                if (c > 0 && grid[r][c - 1] == 1) {
                    result -= 2
                }
            }
        }
    }

    return result
}

fun main() {
    var matrix = arrayOf(intArrayOf(
            0,1,0,0), intArrayOf(
            1,1,1,0), intArrayOf(
            0,1,0,0), intArrayOf(
            1,1,0,0))

    println(islandPerimeter(matrix))
}