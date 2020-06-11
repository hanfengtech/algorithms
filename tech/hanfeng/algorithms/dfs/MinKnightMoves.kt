package tech.hanfeng.algorithms.dfs

import java.util.*

val DIRECTIONS = arrayOf(intArrayOf(-1,-2), intArrayOf(-2,-1), intArrayOf(-2,1), intArrayOf(-1,2),
        intArrayOf(1,2), intArrayOf(2,1), intArrayOf(2,-1), intArrayOf(1,-2))

fun minKnightMoves(ix : Int, iy : Int) : Int {
    var x = Math.abs(ix)
    var y = Math.abs(iy)

    val q = LinkedList<IntArray>()
    q.add(intArrayOf(0,0))

    val visisted = HashSet<String>()
    visisted.add("0,0")

    var steps = 0

    while (!q.isEmpty()) {
        var size = q.size
        for (i in 0 until size) {
            val pos = q.remove()
            val posx = pos[0]
            val posy = pos[1]
            if (posx == x && posy == y) return steps

            for (direction in DIRECTIONS) {
                val nextx = posx + direction[0]
                val nexty = posy + direction[1]
                val nextxy = intArrayOf(nextx, nexty)

                val nextpos = "$nextx,$nexty"
                if (!visisted.contains(nextpos) && nextx >= -1 && nexty >= -1) {
                    q.offer(nextxy)
                    visisted.add(nextpos)
                }

            }
        }
        steps++
    }

    return -1
}

fun main() {
    println(minKnightMoves(5,5))
}