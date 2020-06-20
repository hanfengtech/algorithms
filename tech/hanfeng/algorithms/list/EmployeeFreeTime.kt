package tech.hanfeng.algorithms.list

import java.util.*
import kotlin.collections.ArrayList

data class Interval(var start : Int, var end : Int)

fun employeeFreeTime(schedule : List<List<Interval>>) : List<Interval> {
    var res = ArrayList<Interval>()
    var pq = PriorityQueue<Interval> { a, b -> a.start - b.start }  // Min Heap
    schedule.forEach { pq.addAll(it) }
    var curr = pq.remove()

    while(!pq.isEmpty()) {
        if (curr.end < pq.peek().start) {  // no intersection
            res.add(Interval(curr.end, pq.peek().start))
            curr = pq.remove()
        } else {    // merge intersection
            var tmp = pq.remove()
            curr.start = minOf(curr.start, tmp.start)
            curr.end = maxOf(curr.end, tmp.end)
        }
    }

    return res
}

fun main() {
    val result = employeeFreeTime(listOf(listOf(Interval(1,2), Interval(5,6)),
            listOf(Interval(1,3)), listOf(Interval(4,10))))

    println(result.joinToString())
}