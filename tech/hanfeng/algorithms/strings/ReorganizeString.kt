package tech.hanfeng.algorithms.strings

import java.util.*

data class CharCounter(var letter : Char, var count : Int)

fun reorganizeString(s : String) : String {
    val N = s.length
    var count = IntArray(26)
    for (c in s) {
        count[c - 'a']++
    }

    val pq = PriorityQueue<CharCounter>{ a, b ->
        if (a.count == b.count)
            a.letter - b.letter
        else
            b.count - a.count
    }

    for (i in 0 until 26) {
        val maxCount = (N + 1) / 2
        if (count[i] > 0) {
            if (count[i] > maxCount) {
                return ""
            }
            pq.add(CharCounter(('a' + i), count[i]))
        }
    }

    val ans = StringBuilder()
    while(pq.size >= 2) {
        val cc1 = pq.poll()
        val cc2 = pq.poll()

        ans.append(cc1.letter)
        ans.append(cc2.letter)

        if (--cc1.count > 0) pq.add(cc1)
        if (--cc2.count > 0) pq.add(cc2)
    }

    if (pq.size > 0) ans.append(pq.poll().letter)
    return ans.toString()
}

fun main() {
    println(reorganizeString("aaabbc"))
    println(reorganizeString("aaab"))
}