package tech.hanfeng.algorithms.array

import java.util.*

fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    if (n < 1 || logs.isEmpty()) return intArrayOf()

    val stack = LinkedList<Int>()
    val res = IntArray(n)
    var prev = 0

    for (log in logs) {
        try {
            val (id, event, timestamp) = log.split(":")
            val time = timestamp.toInt()
            if (event == "start") {
                if (stack.isNotEmpty()) {
                    res[stack.peek()] += time - prev
                }
                stack.push(id.toInt())
                prev = time
            } else {
                res[stack.peek()] += time - prev + 1
                stack.pop()
                prev = time + 1
            }
        } catch (e : IndexOutOfBoundsException) {
            e.printStackTrace()
            return intArrayOf()
        }
    }
    return res
}

fun main() {
    val logs = arrayListOf("0:start:0:8","1:start:2:9","1:end:5:9","0:end:6:8")
    println(exclusiveTime(2, logs).contentToString())
}

