package tech.hanfeng.algorithms.dp

fun kpalidrome(s : String, k : Int) : Boolean {
    val t = s.reversed()
    val n = s.length
    val count = helper(s, t, n, n)
    //print(count)
    return count <= k * 2
}

fun helper(s: String, t : String, m : Int, n : Int) : Int {
    val dp = Array(m + 1) { IntArray (n + 1) }

    // i for row and j for col
    for (i in 0 .. m) {
        for (j in 0 .. n) {
            if (i == 0) {
                dp[i][j] = j
            } else if (j == 0) {
                dp[i][j] = i
            } else if (s[j - 1] == t[i - 1]) {
                dp[i][j] = dp[i -1][j - 1]
            } else {
                dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    return dp[m][n]
}

fun main() {
    println(kpalidrome("abcdecba", 1))
}