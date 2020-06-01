package tech.hanfeng.algorithms.array

import java.util.*


fun leastInterval(tasks: CharArray, n: Int): Int {
    val map = IntArray(26)
    for (c in tasks) map[c - 'A']++
    Arrays.sort(map)
    val max = map[25] - 1
    var idelSlots = max * n
    var i = 24
    while (i >= 0 && map[i] > 0) {
        idelSlots -= Math.min(map[i], max)
        i--
    }
    return if (idelSlots > 0) idelSlots + tasks.size else tasks.size
}

fun main() {
    println(leastInterval(charArrayOf('A', 'A', 'A', 'B','B', 'B'), 2))
}

