package tech.hanfeng.algorithms.strings

fun minWindow(s: String, t: String): String {
    if (s.isEmpty() || t.isEmpty()) return ""
    val freq = IntArray(128)
    var start = 0
    var end = 0
    var remaining = t.length
    var minStart = 0
    var minLen = Int.MAX_VALUE


    t.forEach {
        freq[it.toInt()]++
    }

    while (end < s.length) {
        if (--freq[s[end++].toInt()] >= 0) remaining--

        while (remaining == 0) {
            if (end - start < minLen) {
                minLen = end - start
                minStart = start
            }
            if (++freq[s[start++].toInt()] > 0) remaining++
        }
    }

    return if (minLen < Int.MAX_VALUE) s.substring(minStart, minStart + minLen) else ""
}

fun main() {
    println(minWindow("ADOBECODEBANC", "ABC"))
    println(minWindow("ab", "a"))
}