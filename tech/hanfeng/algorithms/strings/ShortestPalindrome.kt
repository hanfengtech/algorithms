package tech.hanfeng.algorithms.strings

fun shortestPalindrome(s : String) : String {
    var i = 0
    for (j in s.lastIndex downTo 0)
        if (s[i] == s[j])
            i++

    if (i == s.length)
        return s

    val suffix = s.substring(i)

    return suffix.reversed() + shortestPalindrome(s.substring(0, i)) + suffix
}

fun main() {
    println(shortestPalindrome("aabecaaa"))
    println(shortestPalindrome("abcd"))
}