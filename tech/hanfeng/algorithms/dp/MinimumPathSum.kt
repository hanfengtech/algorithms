package tech.hanfeng.algorithms.dp

fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.size == 0) {
        return -1
    }

    val m = grid.size
    val n = grid[0].size
    val result = IntArray(n)

    result[0] = grid[0][0]

    for (i in 0 until m) {
        for (j in 0 until n) {
            val up = if (i > 0) { grid[i][j] + result[j] } else Int.MAX_VALUE   // up
            val left = if (j > 0) { grid[i][j] + result[j - 1] } else Int.MAX_VALUE   // left
            if (i == 0 && j == 0) {
                continue
            }
            result[j] = Math.min(up, left)
        }
    }
    return result[n - 1]
}

fun main() {
    val grid = arrayOf(intArrayOf(1,3,1),
                       intArrayOf(1,5,1),
                       intArrayOf(4,2,1))

    println(minPathSum(grid))

}