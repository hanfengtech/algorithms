package tech.hanfeng.algorithms.array

import java.util.*

fun minMeetingRooms(intervals : Array<IntArray>): Int {
    intervals.sortBy { it[0] }
    var pq = PriorityQueue<IntArray> { a, b -> a[1] - b[1]}

    for( interval in intervals) {
        if (pq.isNotEmpty() && pq.peek()[1] <= interval[0]) {
            val v = pq.poll()
        }
        pq.add(interval)
    }
    return pq.size
}

fun main() {
    println(minMeetingRooms(arrayOf(intArrayOf(0,30), intArrayOf(5,10), intArrayOf(15,20))))
}