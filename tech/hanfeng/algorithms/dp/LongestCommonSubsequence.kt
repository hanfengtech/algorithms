package tech.hanfeng.algorithms.dp

fun longestCommonSubsequence(X: String, Y: String): Int {
    val m = X.length
    val n = Y.length
    val L = Array(m + 1) { IntArray(n + 1) }

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 || j == 0) L[i][j] = 0
            else if (X[i - 1] == Y[j - 1]) L[i][j] = L[i - 1][j - 1] + 1
            else L[i][j] = Math.max(L[i - 1][j], L[i][j - 1])
        }
    }
    return L[m][n]
}

fun main() {
    println(longestCommonSubsequence("abcde", "ace"))
    println(longestCommonSubsequence("abc", "abc"))
    println(longestCommonSubsequence("abc", "def"))
}