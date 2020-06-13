package tech.hanfeng.algorithms.recursion

fun solveSudoku(board : Array<CharArray>) {
    if (board.isEmpty()) {
        return
    }
    solve(board)
}

fun solve(board : Array<CharArray>) : Boolean {
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == '.') {
                for (c in '1' .. '9') {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c

                        if (solve(board)) {
                            return true
                        } else {
                            board[i][j] = '.'
                        }
                    }
                }
                return false
            }
        }
    }
    return true
}

fun isValid(board: Array<CharArray>, row : Int, col : Int, c : Char): Boolean {
    for (i in 0 until 9) {
        if (board[i][col] != '.' && board[i][col] == c)   // check row
            return false
        if (board[row][i] != '.' && board[row][i] == c)   // check column
            return false

        val y = 3 * (row / 3) + i / 3
        val x = 3 * (col / 3) + i % 3

        if (board[y][x] != '.' &&  board[y][x] == c)    // check 3 * 3 block
            return false
    }
    return true
}

//        0        1        2
// 0 1 2
// 0    // 3 4 5   row = 1 col = 1
// 6 7 8


// 1



// 2

// 3 * 1/3 + 0 /3 = 0
// 3 * 1/3 + 0 % 3 = 0

// 3 * 1/3 + 1 /3 = 0
// 3 * 1/3 + 1 % 3 = 1

// 3 * 1/3 + 2 /3 = 0
// 3 * 1/3 + 2 % 3 = 2

// 3 * 1/3 + 3 /3 = 1
// 3 * 1/3 + 3 % 3 = 0

// 3 * 1/3 + 4 / 3 = 1
// 3 * 1/3 + 4 % 3 = 1

// 3 * 1/3 + 5 / 3 = 1
// 3 * 1/3 + 5 % 3 = 2

// 3 * 1/3 + 6 / 3 = 2
// 3 * 1/3 + 6 % 3 = 0

// 3 * 1/3 + 7 / 3 = 2
// 3 * 1/3 + 7 % 3 = 1

// 3 * 1/3 + 8 / 3 = 2
// 3 * 1/3 + 8 % 3 = 2


// 3 * 3/3 + 8 / 3 = 5
// 3 * 3/3 + 8 % 3 = 5

fun main() {
    val sudoku = Array(9) { CharArray(9) { '.' } }
    solveSudoku(sudoku)
    for (i in sudoku.indices) {
        for (j in sudoku[i].indices) {
            print(sudoku[i][j])

            if (j < sudoku[i].size - 1) {
                print("  ")
            }
        }
        println()
        println()
    }
}