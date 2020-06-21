package tech.hanfeng.algorithms.dp

fun isMatch(s : String, p : String) : Boolean {
    var n = s.length
    var m = p.length

    var dp = Array(n + 1) { BooleanArray(m + 1) }
    dp[0][0] = true

    for (j in 1 .. m) {
         if (p[j-1] == '*') {
             dp[0][j] = dp[0][j - 1]
         }
    }

    for (i in 1 .. n) {
        for(j in 1 .. m) {
            if (s[i - 1] == p[j - 1] || p[j - 1] == '?') {
                dp[i][j] = dp[i - 1][j - 1]
            } else if (p[j - 1] == '*') {
                dp[i][j] = dp[i - 1][j] or dp[i][j - 1]
            }
        }
    }

    return dp[n][m]
}

fun main() {
    println(isMatch("adceb", "*a*b"))

}