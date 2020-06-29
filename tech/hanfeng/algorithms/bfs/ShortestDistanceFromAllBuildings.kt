package tech.hanfeng.algorithms.bfs

import java.util.*

class ShortestDistanceFromAllBuildings {
    private data class Location(var x : Int, var y : Int)
    private val directions = arrayOf(Location(0, 1), Location(0, -1), Location(1, 0), Location(-1, 0))

    fun shortestDistance(grid: Array<IntArray>): Int {
        val distances = Array(grid.size) { IntArray(grid[0].size) }
        val reach = Array(grid.size) { IntArray(grid[0].size) }
        var buildings = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {     // if is a building
                    buildings += 1
                    bfs(i, j, grid, distances, reach)
                }
            }
        }

        return getMin(grid, distances, reach, buildings)
    }

    private fun bfs(i : Int, j : Int, grid : Array<IntArray>, distances : Array<IntArray>, reach : Array<IntArray>) {
        var depth = 1
        val q = LinkedList<Location>()              // queue the coordinate for bfs
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        q.offer(Location(i, j))
        while (q.isNotEmpty()) {
            val size = q.size
            repeat(size) {
                val loc = q.poll()
                for ( (dx, dy) in directions) {
                    val x = loc.x + dx
                    val y = loc.y + dy
                    if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size ||
                            visited[x][y] || grid[x][y] == 2 || grid[x][y] == 1) continue
                    visited[x][y] = true
                    distances[x][y] += depth
                    reach[x][y] += 1
                    q.offer(Location(x, y))
                }
            }
            depth++
        }
    }

    private fun getMin(grid : Array<IntArray>, distances : Array<IntArray>, reach : Array<IntArray>, buildings : Int) : Int {
        var min = Int.MAX_VALUE
        for (i in distances.indices) {
            for (j in distances[i].indices) {
                if (grid[i][j] == 0 && reach[i][j] == buildings) {
                    min = minOf(min, distances[i][j])
                }
            }
        }
        return if (min == Int.MAX_VALUE) -1 else min
    }
}

fun main() {
    val shortestDistanceFromAllBuildings = ShortestDistanceFromAllBuildings()
    println(shortestDistanceFromAllBuildings.shortestDistance(arrayOf(intArrayOf(1,0,2,0,1), intArrayOf(0,0,0,0,0), intArrayOf(0,0,1,0,0))))
}