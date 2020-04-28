package tech.hanfeng.algorithms.dp

fun maximalSquare(matrix : Array<CharArray>) : Int {
    val rows = matrix.size
    val cols = if (rows > 0) matrix[0].size else 0
    val dp = IntArray(cols + 1)
    var maxsqlen = 0
    var prev = 0

    for (i in 1 .. rows) {
        for (j in 1 .. cols) {
            val tmp = dp[j]
            if (matrix[i - 1][j - 1] == '1') {
                dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1
                print("${dp[j]},")
                maxsqlen = Math.max(maxsqlen, dp[j])
            } else {
                dp[j] = 0
            }
            prev = tmp
        }
        println()
    }

    return maxsqlen * maxsqlen
}

fun main() {
    println(maximalSquare(arrayOf(
            charArrayOf('0', '1', '1', '1', '0'),
            charArrayOf('0', '1', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0'))))
}