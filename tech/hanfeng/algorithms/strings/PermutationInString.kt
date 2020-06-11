package tech.hanfeng.algorithms.strings

fun checkInclusion2(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false
    val s1map = IntArray(26)
    val s2map = IntArray(26)
    for (i in s1.indices) {
        s1map[s1[i] - 'a']++
        s2map[s2[i] - 'a']++
    }
    for (i in 0 until s2.length - s1.length) {
        if (matches(s1map, s2map)) return true
        s2map[s2[i + s1.length] - 'a']++
        s2map[s2[i] - 'a']--
    }
    return matches(s1map, s2map)
}

fun matches(s1map: IntArray, s2map: IntArray): Boolean {
    for (i in 0..25) {
        if (s1map[i] != s2map[i]) return false
    }
    return true
}

fun checkInclusion(s1: String, s2: String): Boolean {
    val freq = IntArray(26)
    for(e in s1) {
        freq[e - 'a']++
    }
    var start = 0
    var end = 0
    var count = s1.length
    while(end < s2.length) {
        if(freq[s2[end++] - 'a']-- > 0) count--
        if(count == 0) return true
        if(end - start == s1.length && freq[s2[start++] - 'a']++ >= 0) count++
    }
    return false
}

fun main() {
    println(checkInclusion("ab", "eidbcabooo"))
}