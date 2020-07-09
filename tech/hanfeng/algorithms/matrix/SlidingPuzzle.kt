package tech.hanfeng.algorithms.matrix

import java.util.*

private const val SOLUTION = "123450"
class SlidingPuzzle {
    private val directions = arrayOf(intArrayOf(1,3), intArrayOf(0,2,4), intArrayOf(1,5),
                                     intArrayOf(0,4), intArrayOf(1,3,5), intArrayOf(2,4))
    fun slidingPuzzle(board: Array<IntArray>) : Int {
        val sb = StringBuilder()
        for (i in board.indices)
            for (j in board[0].indices)
                sb.append(board[i][j])

        var swaps = -1
        val seen = HashSet<String>()
        val q = LinkedList<String>().apply { this.offer(sb.toString()) }

        while(q.isNotEmpty()) {
            swaps++
            var size = q.size
            while(size-- > 0) {
                val state = q.poll()
                if(state == SOLUTION) {
                    return swaps
                } else {
                    val zeroPosition = state.indexOf('0')
                    for (dir in directions[zeroPosition]) {
                        val newState = swap(state, zeroPosition, dir)
                        if (newState !in seen) {
                            seen.add(state)
                            q.offer(newState)
                        }
                    }
                }
            }
        }
        return -1
    }

    private fun swap(str: String, i : Int, j : Int) : String = StringBuilder(str).apply { this[i] = str[j]; this[j] = str[i] }.toString()
}

fun main() {
    var board = arrayOf(intArrayOf(1,2,3), intArrayOf(4,0,5))
    val slidingPuzzle = SlidingPuzzle()
    println(slidingPuzzle.slidingPuzzle(board))

    board = arrayOf(intArrayOf(4,1,2), intArrayOf(5,0,3))
    println(slidingPuzzle.slidingPuzzle(board))

}