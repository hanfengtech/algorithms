package tech.hanfeng.algorithms.strings

fun isAnagram(s : String, t : String) : Boolean {
    if (s.length != t.length) return false

    val freq = IntArray(26)

    for (i in s.indices) {
        freq[s[i] - 'a']++
    }

    for (ch in t) {
        var i = ch - 'a'
        freq[i]--
        if (freq[i] < 0) {
            return false
        }
    }

    return true
}

fun main() {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "cat"))
}