package tech.hanfeng.algorithms.dp

class RegularExpressionMatching {

    fun isMatch(s : String, p : String) : Boolean {
        val m: Int = s.length
        val n: Int = p.length
        val dp = Array(m + 1) { BooleanArray(n + 1) }
        dp[0][0] = true
        for (i in 2..n) {
            if (p[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2] // *可以消掉c*     a*b*c*
            }
        }

        for (i in 1..m) {
            for (j in 1..n) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1]                    // upper left diagonal
                } else if (p[j - 1] == '*') {
                    if (s[i - 1] == p[j - 2] || p[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j]    // left, left left, up
                    } else {
                        dp[i][j] = dp[i][j - 2] // 用*消掉c*    //  left left
                    }
                } else {
                    dp[i][j] = false
                }
            }
        }

        return dp[m][n]
    }
}

fun main() {
    println(RegularExpressionMatching().isMatch("aab", "c*a*b"))
    println(RegularExpressionMatching().isMatch("ab", ".*"))
}