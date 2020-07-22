package tech.hanfeng.algorithms.implementation

class TicTacToe(n: Int) {

    lateinit var row : Array<IntArray>
    lateinit var col : Array<IntArray>
    lateinit var diag1 : IntArray
    lateinit var diag2 : IntArray
    var n : Int

    init {
        row = Array(n) { IntArray(2)}
        col = Array(n) { IntArray(2)}
        diag1 = IntArray(2)
        diag2 = IntArray(2)
        this.n = n
    }

    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
    0: No one wins.
    1: Player 1 wins.
    2: Player 2 wins. */
    fun move(r: Int, c: Int, player: Int): Int {
        var playerIdx = player - 1

        // checks for r/c win
        row[r][playerIdx]++
        col[c][playerIdx]++
        if (row[r][playerIdx] == n || col[c][playerIdx] == n) return player

        // checks for diagonal win
        if (r == c) diag1[playerIdx]++
        if (r + c == n - 1) diag2[playerIdx]++
        if (diag1[playerIdx] == n || diag2[playerIdx] == n) return player

        return 0
    }

}