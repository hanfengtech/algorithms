package tech.hanfeng.algorithms.dp

fun numDecodings(s : String) : Int {
    val len = s.length
    val dp = IntArray(len + 1)
    var first = 1
    var second = if ('0' == s[0]) 0 else 1

    for (i in 2 until dp.size) {
        var temp = 0
        val currDigit = s[i - 1] - '0'
        val twoDigits = (s[i - 2] - '0') * 10 + currDigit

        if (currDigit >= 1)
            temp += second

        if (twoDigits in 10..26) {
            temp += first
        }

        first = second
        second = temp
    }

    return second
}

fun main() {
    println(numDecodings("12"))
    println(numDecodings("226"))
    println(numDecodings("220"))
}