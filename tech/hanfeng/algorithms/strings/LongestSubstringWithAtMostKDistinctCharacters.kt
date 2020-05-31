package tech.hanfeng.algorithms.strings

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.set

fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
    var n = s.length
    if (n * k == 0) return 0

    var left = 0
    var right = 0

    var map = HashMap<Char, Int>()

    var max = 1

    while (right < n) {
        map[s[right]] = right++

        if (map.size == k + 1) {
            val del_idx = Collections.min(map.values)
            map.remove(s[del_idx])
            left = del_idx + 1
        }

        max = Math.max(max, right - left)
    }
    return max
}

fun lengthOfLongestSubstringKDistinct2(s: String, k: Int): Int {
    var r = 0
    var l = 0
    var res = 0
    var curDistinct = 0
    val freq = IntArray(256)
    while (r < s.length) {
        if (++freq[s[r++].toInt()] == 1) curDistinct++
        while (curDistinct > k) if (--freq[s[l++].toInt()] == 0) curDistinct--
        res = Math.max(r - l, res)
    }
    return res
}

fun main() {
    println(lengthOfLongestSubstringKDistinct("eceba", 2))
}