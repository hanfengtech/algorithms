package tech.hanfeng.algorithms.dp

class NumMatrix(matrix: Array<IntArray>) {

    var m : Array<IntArray>? = null

    var dp : Array<IntArray>? = null

    init{
        m = matrix

        dp = Array(matrix.size+1) {IntArray(matrix[0].size+1)}

        for (r in matrix.indices) {
            for (c in matrix[0].indices) {
                dp!![r+1][c+1] = dp!![r+1][c] + dp!![r][c+1] + matrix[r][c] - dp!![r][c]
            }
        }
    }

    fun sumRegionDP(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        if (dp!!.size == 1 && dp!![0].size == 1) return 0
        return dp!![row2 + 1][col2 + 1] - dp!![row1][col2 + 1] - dp!![row2+1][col1] + dp!![row1][col1]
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var sum = 0

        for (i in row1 .. row2) {
            for (j in col1 .. col2) {
                sum += m!![i][j]
            }
        }

        return sum
    }



}
