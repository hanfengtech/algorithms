package tech.hanfeng.algorithms.array

fun isValidSudoku(board : Array<CharArray>) : Boolean {
    if (board.isEmpty())
        return false

    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] != '.') {
                if (!checkValid(board, i, j, board[i][j])) {
                    return false
                }
            }
        }
    }

    return true
}

fun checkValid(board: Array<CharArray>, row: Int, col: Int, num : Char) : Boolean {
    for (i in board[row].indices) {  // check row
        if (i != col) {
            if (board[row][i] == num) {
                return false
            }
        }
    }

    for (i in board.indices) {       // check column
        if (i != row) {
            if (board[i][col] == num) {
                return false
            }
        }
    }

    for (i in 0 until 9) {              // check 3*3
        val y = 3 * (row / 3) + i / 3
        val x = 3 * (col / 3) + i % 3

        if (y == row && x == col) {
            continue
        }

        if (board[y][x] == num) {
            return false
        }
    }

    return true
}

fun main() {
    val sudoku = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println(isValidSudoku(sudoku))
}

