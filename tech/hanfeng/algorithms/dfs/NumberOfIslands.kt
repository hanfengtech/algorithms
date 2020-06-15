package tech.hanfeng.algorithms.dfs

fun numIslands(grid : Array<CharArray>) : Int {
    val n = grid.size
    if (n == 0) return 0
    val m = grid[0].size
    if (m == 0) return 0

    fun dfs(grid : Array<CharArray>, i : Int, j: Int) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return

        grid[i][j] = '0'
        dfs(grid, i + 1, j)
        dfs(grid, i - 1, j)
        dfs(grid, i, j + 1)
        dfs(grid, i, j - 1)
    }

    var count = 0
    for(i in 0 until n) {
        for (j in 0 until m) {
            if (grid[i][j] == '1') {
                dfs(grid, i, j)
                count++
            }
        }
    }
    return count
}

fun main() {
    val islands = arrayOf(
            charArrayOf('1','1','0','0','0'),
            charArrayOf('1','1','0','0','0'),
            charArrayOf('0','0','1','0','0'),
            charArrayOf('0','0','0','1','1'))

    println(numIslands(islands))
}