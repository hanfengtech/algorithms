package tech.hanfeng.algorithms.matrix

import java.util.*

const val EMPTY = Int.MAX_VALUE
const val GATE = 0

class WallsAndGates {
    data class Location(var x: Int, var y: Int)
    private var directions = arrayOf(Location(0, 1), Location(0, -1), Location(1, 0), Location(-1, 0))

    fun wallsAndGates(rooms : Array<IntArray>) {
        val m = rooms.size
        if (m == 0) return
        val n = rooms[0].size
        var q = LinkedList<Location>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (rooms[i][j] == GATE)
                    q.offer(Location(i,j))
            }
        }

        while (q.isNotEmpty()) {
            var point = q.poll()
            var x = point.x
            var y = point.y
            for (dir in directions) {
                val r = x + dir.x
                val c = y + dir.y
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) continue
                rooms[r][c] = rooms[x][y] + 1
                q.add(Location(r,c))
            }
        }
    }
}
