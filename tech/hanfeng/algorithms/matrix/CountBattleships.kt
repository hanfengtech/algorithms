package tech.hanfeng.algorithms.matrix

fun countBattleships(board : Array<CharArray>) : Int {
    var total = 0
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == '.') continue
            if (i > 0 && board[i - 1][j] == 'X') continue
            if (j > 0 && board[i][j - 1] == 'X') continue
            total++
        }
    }
    return total
}
