package tech.hanfeng.algorithms.strings

fun longestPalindrome(s : String) : String {
    if (s.length < 2) return s

    var startIndex = 0
    var maxLen = 0

    fun extendPalindrome(j : Int, k : Int) {
        var begin = j
        var end = k

        while (begin >= 0 && end < s.length && s[begin] == s[end]) {
            begin--
            end++
        }

        val newMaxLen = end - begin - 1
        if (newMaxLen > maxLen) {
            startIndex = begin + 1
            maxLen = newMaxLen
        }
    }

    for (i in 0 until s.length - 1) {
        extendPalindrome(i, i)
        extendPalindrome(i, i + 1)
    }

    return s.substring(startIndex, startIndex + maxLen)
}

fun main() {
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
}