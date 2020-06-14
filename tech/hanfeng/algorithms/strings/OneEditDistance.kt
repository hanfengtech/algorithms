package tech.hanfeng.algorithms.strings

fun isOneEditDistance(s: String, t: String): Boolean {
    var i = 0
    while (i < Math.min(s.length, t.length)) {   // find the first different character
        val ch1 = s[i]
        val ch2 = t[i]
        if (ch1 != ch2) break
        i++
    }
    // equal
    if (i == s.length && i == t.length) return false
    if (i + 1 <= t.length) {
        if (s.substring(i) == t.substring(i + 1)) return true
    }
    if (i + 1 <= s.length) {
        if (s.substring(i + 1) == t.substring(i)) return true
    }
    if (i + 1 <= t.length && i + 1 <= s.length) {
        if (s.substring(i + 1) == t.substring(i + 1)) return true
    }
    return false
}


fun main() {
    println(isOneEditDistance("ab", "cab"))
    println(isOneEditDistance("ab", "acb"))
    println(isOneEditDistance("cab", "ad"))
    println(isOneEditDistance("1203", "1203"))
    println(isOneEditDistance("1203", "1213"))

}