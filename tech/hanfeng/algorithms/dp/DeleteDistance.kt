package tech.hanfeng.algorithms.dp

fun deleteDistance(str1 : String, str2 : String) : Int {
    val m = str1.length
    val n = str2.length
    val dp = Array(m + 1) { IntArray(n + 1)}

    for (i in 0 .. m) {
        for (j in 0 .. n) {
            if (i == 0) {
                dp[i][j] = j
            } else if (j == 0) {
                dp[i][j] = i
            } else {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1
                }
            }
        }
    }

    return dp[m][n]
}

fun main() {
    println(deleteDistance("dog", "frog"))
    println(deleteDistance("some", "some"))
    println(deleteDistance("some", "thing"))
    println(deleteDistance("", ""))
}