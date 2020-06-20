package tech.hanfeng.algorithms.strings

fun longestPalindromeLength(s: String): Int {
    var count = IntArray(128)
    var length = 0
    for (c in s) {
        var index = c.toInt()
        if (++count[index] == 2) {
            length += 2
            count[index] = 0
        }
    }
    return if (length == s.length) length else length + 1
}

fun main() {
    println(longestPalindromeLength("abccccdd"))
}