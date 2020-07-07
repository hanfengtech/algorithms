package tech.hanfeng.algorithms.dp

fun isValidPalindrome(s: String, k: Int): Boolean {
    if (s.isEmpty()) return true
    val n = s.length
    val dp = Array(n) { IntArray(n) }
    for (i in s.lastIndex downTo 0) {
        for (j in i until n) {
            if (i == j) {
                dp[i][j] = 1
                continue
            }
            dp[i][j] = if (s[i] == s[j]) {
                dp[i + 1][j - 1] + 2
            } else {
                maxOf(dp[i + 1][j], dp[i][j - 1])
            }
        }
    }
    return n - dp[0][s.lastIndex] <= k
}

fun main() {
    println(isValidPalindrome("abcdeca", 3))
}