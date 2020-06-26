package tech.hanfeng.algorithms.greedy

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    var result = ArrayList<IntArray>()
    var newStart = newInterval[0]
    var newEnd = newInterval[1]

    val n = intervals.size

    var i = 0
    while (i < n && intervals[i][1] < newStart)
        result.add(intervals[i++])

    while(i < n && intervals[i][0] <= newEnd) {
        newStart = minOf(newStart, intervals[i][0])
        newEnd = maxOf(newEnd, intervals[i][1])
        i++
    }
    result.add(intArrayOf(newStart, newEnd))

    while(i < n)
        result.add(intervals[i++])

    return result.toTypedArray()
}

fun main() {
     var intervals = arrayOf(intArrayOf(1,3), intArrayOf(6,9))
     val result = insert(intervals, intArrayOf(2,5))
     result.forEach {
         print(it.contentToString())
     }
}

