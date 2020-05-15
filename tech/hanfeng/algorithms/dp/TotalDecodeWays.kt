package tech.hanfeng.algorithms.dp

fun numDecodings(s : String) : Int {
    val len = s.length
    val dp = IntArray(len + 1)
    dp[0] = 1
    dp[1] = if ('0' == s[0]) 0 else 1

    for(i in 2 until dp.size) {
        val currDigit = s[i - 1] - '0'
        val twoDigits = (s[i - 2] - '0') * 10 + currDigit

        if (currDigit >= 1)
            dp[i] += dp[i - 1]

        if (twoDigits in 10..26) {
            dp[i] += dp[i-2]
        }
    }

    return dp[len]
}

fun main() {
    println(numDecodings("10212"))
    println(numDecodings("226"))
    println(numDecodings("220"))
}