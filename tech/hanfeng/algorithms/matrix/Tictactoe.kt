package tech.hanfeng.algorithms.matrix

fun tictactoe(moves: Array<IntArray>): String {
    if (moves.isEmpty()) return "No moves Yet!"
    val board = Array(3){ CharArray(3) }
    moves.forEachIndexed { i, move ->
        val c = if (i % 2 == 0) 'A' else 'B'
        val row = move[0]
        val col = move[1]
        board[row][col] = c
        if (validate(board, row, col, c)){
            return "$c"
        }
    }
    return if (moves.size < 9) "Pending" else "Draw"
}

fun validate(board : Array<CharArray>, row : Int, col : Int, c : Char) : Boolean {
    // check row
    var isWon = true
    for (j in board[0].indices) {
        if (board[row][j] != c) {
            isWon = false
            break
        }
    }

    if (isWon) return true

    // check col
    isWon = true
    for (i in board.indices) {
        if (board[i][col] != c) {
            isWon = false
            break
        }
    }

    if (isWon) return true

    // check front diag
    if (row == col) {
        isWon = true
        for (i in board.indices) {
            if (board[i][i] != c) {
                isWon = false
            }
        }
        if (isWon) return true
    }

    // check back diag
    if (row+col == board.size - 1) {
        isWon = true
        for (i in board.indices) {
            if (board[i][board.size - i - 1] != c) {
                isWon = false
            }
        }
        if (isWon) return true
    }

    return false
}

fun main() {

   println(tictactoe(arrayOf(intArrayOf(0,0),intArrayOf(2,0),
           intArrayOf(1,1),intArrayOf(2,1),intArrayOf(2,2))))


    println(tictactoe(arrayOf(intArrayOf(0,0),intArrayOf(1,1),
            intArrayOf(0,1),intArrayOf(0,2),intArrayOf(1,0),intArrayOf(2,0))))
}

