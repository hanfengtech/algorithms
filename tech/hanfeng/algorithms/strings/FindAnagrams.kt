package tech.hanfeng.algorithms.strings

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun findAnagramsB(s: String, p: String): List<Int> {
    val n = p.length
    val resultList = ArrayList<Int>()

    if (s.isEmpty()) return resultList

    var psorted = p.toCharArray()
    psorted.sort()

    for (i in 0 until s.length - n + 1) {
        val substring = s.substring(i, i + n).toCharArray()
        substring.sort()

        if (isSame(psorted, substring)) {
            resultList.add(i)
        }
    }

    return resultList
}

fun isSame(a : CharArray, b : CharArray) : Boolean {
    for (i in a.indices) {
        if (a[i] != b[i])
            return false
    }
    return true
}

fun findAnagramsHash(s: String, p: String) : List<Int> {
    val ns = s.length
    val np = p.length
    if (ns < np) return ArrayList()
    var sCountMap = HashMap<Char, Int>()
    var pCountMap = HashMap<Char, Int>()

    p.forEach {
        if (pCountMap.containsKey(it)) {
            pCountMap[it] = pCountMap[it]!!.plus(1)
        } else {
            pCountMap[it] = 1
        }
    }

    val output = ArrayList<Int>()

    for (i in 0 until ns) {
        var ch = s[i]
        if (sCountMap.containsKey(ch)) {
            sCountMap[ch] = sCountMap[ch]!!.plus(1)
        } else {
            sCountMap[ch] = 1
        }

        if (i >= np) {
            ch = s[i - np]
            if (sCountMap[ch] == 1) {
                sCountMap.remove(ch)
            } else {
                sCountMap[ch] = sCountMap[ch]!!.minus(1)
            }
        }

        if (pCountMap == sCountMap) {
            output.add(i - np + 1)
        }
    }

    return output
}

fun findAnagrams(s: String, p: String) : List<Int> {
    val pChars = IntArray(26)
    p.forEach { pChars[it - 'a']++ }

    val res = mutableListOf<Int>()
    val sChars = IntArray(26)
    var left = 0
    for (right in s.indices) {
        sChars[s[right] - 'a']++
        if(right >= p.length - 1) {
            if (sChars.contentEquals(pChars)) {
                res.add(left)
            }
            sChars[s[left++] - 'a']--
        }
    }
    return res
}


fun main() {
    println(findAnagrams("cbaebabacd", "abc").joinToString())
}