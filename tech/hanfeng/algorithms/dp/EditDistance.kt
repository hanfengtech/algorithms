package tech.hanfeng.algorithms.dp

fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length

    val dp = Array(m + 1) { IntArray(n + 1) }

    for (i in 0 .. m) {
        for (j in 0 .. n) {
            if (i == 0) {
                dp[i][j] = j
            } else if (j == 0) {
                dp[i][j] = i
            } else if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1])
            }
        }
    }

    return dp[m][n]
}

fun main() {
    println(minDistance("horse", "ros"))
}