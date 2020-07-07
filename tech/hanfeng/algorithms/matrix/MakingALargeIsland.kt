package tech.hanfeng.algorithms.matrix

class MakingALargeIsland {
    fun largestIsland(grid: Array<IntArray>): Int {
        var res = 0
        val m = grid.size
        val n = grid[0].size
        var islands = ArrayList<Int>().apply { add(0) ; add(0) }  // add two dummy values to the list to help indexing the islands correctly starting with 2

        fun dfs(i : Int, j : Int) : Int {
            if (i < 0 || j < 0 || i == m || j == n || grid[i][j] != 1) return 0
            grid[i][j] = islands.size         // Use the size of the islands list to mark the island,  started with size 2
            return 1 + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1)
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    val size = dfs(i,j)      // dfs to get count the size of the land
                    islands.add(size)           // store the size of this island
                    res = maxOf(size, res)   // update the result with maxof
                }
            }
        }

        // if 0, sum up all surrounding islands and add 1
        val islandIndices = HashSet<Int>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) {
                    islandIndices.clear()
                    if (i > 0) islandIndices.add(grid[i - 1][j])
                    if (i < m - 1) islandIndices.add(grid[i + 1][j])
                    if (j > 0) islandIndices.add(grid[i][j - 1])
                    if (j < n - 1) islandIndices.add(grid[i][j + 1])
                    var count = 0
                    for (index in islandIndices)
                        if (index != 0) count += islands[index]
                    res = maxOf(count + 1, res)
                }
            }
        }
        return res
    }
}

fun main() {

    var grid = arrayOf(intArrayOf(1,0), intArrayOf(1, 0))

    var makingALargeIsland = MakingALargeIsland()
    println(makingALargeIsland.largestIsland(grid))
    grid = arrayOf(intArrayOf(1,1), intArrayOf(1, 0))
    println(makingALargeIsland.largestIsland(grid))
    grid = arrayOf(intArrayOf(0,0), intArrayOf(0, 0))
    println(makingALargeIsland.largestIsland(grid))

    grid = arrayOf(intArrayOf(0,0), intArrayOf(0, 1))
    println(makingALargeIsland.largestIsland(grid))

/*
    [0,0,0,0,0,0,0]
    [0,1,1,1,1,0,0]
    [0,1,0,0,1,0,0]
    [1,0,1,0,1,0,0]
    [0,1,0,0,1,0,0]
    [0,1,0,0,1,0,0]
    [0,1,1,1,1,0,0]
 */

}