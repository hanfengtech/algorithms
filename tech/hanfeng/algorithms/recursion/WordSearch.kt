package tech.hanfeng.algorithms.recursion

fun wordSearch(board : Array<CharArray>, word : String) : Boolean {

    fun exist(y : Int, x : Int, i : Int) : Boolean {
        if (i == word.length) {
            return true
        }

        if (y < 0 || x < 0 || y == board.size || x == board[y].size)
            return false

        if (board[y][x] != word[i])
            return false

        val tmp = board[y][x]
        board[y][x] = '#'

        val exist = exist(y, x + 1, i + 1)
                || exist(y, x - 1, i + 1)
                || exist(y + 1, x, i + 1)
                || exist(y - 1, x, i + 1)

        board[y][x] = tmp
        return exist
    }

    for (y in board.indices) {
        for(x in board[y].indices) {
            if (exist(y,x,0)) {
                //println("y = $y, x = ${x} ch = ${board[y][x]}")
                return true
            }
        }
    }
    return false
}

fun main() {

    // var matrix: Array<IntArray> = Array(height) { IntArray(width) }

    val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'))

    println(wordSearch(board, "ABCCED"))
    println(wordSearch(board, "SEE"))
    println(wordSearch(board, "ABCB"))
}