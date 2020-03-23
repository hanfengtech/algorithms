package tech.hanfeng.algorithms.strings

fun firstUniqChar(s : String) : Int {
    val freq = IntArray(26) { 0 }

    for (i in s.indices) {
        freq[s[i] - 'a']++
    }

    for (i in s.indices) {
        if (freq[s[i] - 'a'] == 1) {
            return i
        }
    }

    return -1
}

fun main() {
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))
}