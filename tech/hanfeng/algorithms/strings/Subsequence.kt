package tech.hanfeng.algorithms.strings

fun isSubsequence(s: String, t: String) : Boolean {
    if (s.isEmpty() && t.isEmpty()) return true
    if (s.isEmpty() && t.isNotEmpty()) return true

    var n = s.length    // n = 3
    var m = t.length    // m = 6
    var i = 0           // i = 0, 1, 2, 3
    var j = 0           // j = 0, 1, 2, 3, 4, 5, 6

    while (j < m) {
        if (s[i] == t[j]) {
            i++
            j++
            if (i == n) return true
        } else {
            j++
        }
    }

    return false
}