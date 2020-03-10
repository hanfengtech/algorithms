package tech.hanfeng.algorithms.recursion

import java.util.*
import kotlin.collections.ArrayList

fun solveNQueens(n : Int) : List<List<String>> {
    var resList = ArrayList<List<String>>()

    if (n < 1) return resList

    var board = Array(n) { CharArray(n) {'.'} }

    dfs(board, 0, resList)
    return resList
}

fun dfs(board : Array<CharArray>, colIndex : Int, resList : ArrayList<List<String>>) {
    if (colIndex == board.size) {
        resList.add(construct(board))
        return
    }

    for (i in board.indices) {
        if (isSafe(board, i, colIndex)) {
            board[i][colIndex] = 'Q'
            dfs(board, colIndex + 1, resList)
            board[i][colIndex] = '.'
        }
    }
}

fun isSafe(board: Array<CharArray>, row : Int, col: Int) : Boolean {

    // check if there is Q on the same row (only need to check the current col's left size
    for (i in 0 until col) {
        if (board[row][i] == 'Q')
            return false
    }

    // check upper diagonal
    var i = row
    var j = col

    while(i >=0 && j >= 0) {
        if (board[i][j] == 'Q')
            return false
        i--
        j--
    }

    i = row
    j = col
    // check lower diagonal
    while(i < board.size && j >= 0) {
        if (board[i][j] == 'Q')
            return false
        i++
        j--
    }
    return true
}

fun construct(board: Array<CharArray>): List<String> {
    val res = LinkedList<String>()
    for (i in board.indices) {
        res.add(String(board[i]))
    }
    return res
}

fun validate(board: Array<CharArray>, x : Int, y: Int) : Boolean {
    for (i in board.indices) {
        for (j in 0 until y) {
            if (board[i][j] == 'Q' &&
                    (  x + j == y + i  // diagonal downward
                            || x + y == i + j  // diagonal upward
                            || x == i))
                return false
        }
    }
    return true
}

fun main() {
    println(solveNQueens(4))
}