package tech.hanfeng.algorithms.dp

import tech.hanfeng.algorithms.array.util.printMatrix

/**
 *   Case 1:  single character is P
 *   Case 2:  two characters are same is P
 *   Case 3:  first and last characters are same and within is a P, then it is a P
 */
fun countSubstringsDP(s: String): Int {

    var count = 0
    val dp = Array(s.length) { BooleanArray(s.length) }

    for (i in s.indices) {   // Case 1
        dp[i][i] = true
        count++
    }

    for (col in 1 until s.length) {
        for (row in 0 until col) {  // only upper triangle is needed
            if (row == col - 1 && s[col] == s[row]) {  // Case 2
                dp[row][col] = true
                count++
            } else if (dp[row + 1][col - 1] && s[col] == s[row]) {  // Case 3
                dp[row][col] = true
                count++
            }
        }
    }

    printMatrix(dp, s)

    return count
}

fun countSubstrings(s: String): Int {
    var count = 0

    for (i in s.indices) {
        count += s.expend(i, i)
        count += s.expend(i, i+1)
    }

    return count
}

fun String.expend(from : Int, to : Int) : Int {
    var count = 0
    var left = from
    var right = to

    while(left >= 0 && right < this.length && this[left] == this[right]) {
        left--
        right++
        count++
    }

    return count
}

fun main() {
    println(countSubstrings("abc"))
    println(countSubstrings("aaa"))
}