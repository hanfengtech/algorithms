package tech.hanfeng.algorithms.strings

import java.lang.StringBuilder

fun repeatedSubstringPattern(s : String) : Boolean {
    if (s.isEmpty() || s.length == 1)
        return false

    val len = s.length
    var i = len / 2

    do {
        if (len % i == 0) {
            val m = len / i
            val subStr = s.substring(0, i)
            val sb = StringBuilder()
            for (j in 0 until m) {
                sb.append(subStr)
            }

            if (sb.toString() == s)
                return true
        }
    } while (--i >= 1)

    return false
}

fun main() {
    println(repeatedSubstringPattern("abab"))
    println(repeatedSubstringPattern("aba"))
    println(repeatedSubstringPattern("abcabcabcabcabc"))
    println(repeatedSubstringPattern("a"))
}
