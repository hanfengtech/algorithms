package tech.hanfeng.algorithms.implementation

import java.util.TreeMap
const val START = 0
const val END = 1
class SummaryRanges {
    var map = TreeMap<Int, IntArray>()

    fun addNum(`val`: Int) {
        val floor = map.floorKey(`val`)
        val ceiling = map.ceilingKey(`val`)
        val interval = intArrayOf(`val`, `val`)
        if (floor != null) {
            val floorEnd = map[floor]!![END]
            if (`val` <= floorEnd) return              // [1,3] [2]  value is less than floor's end value, just return
            if (`val` == floorEnd + 1) {               // [1,6] [7]  if the value equals floor's end plus one
                interval[START] = floor                // set the start of new interval to floor's start
                map.remove(floor)                      // remove the old floor
            }
        }

        if (ceiling != null && `val` == ceiling - 1) {  // [6,9] [5]  the new value is 1 less than the ceiling's start
            interval[END] = map[ceiling]!![END]         // set the end of the new interval to ceiling's end
            map.remove(ceiling)                         // remove the old ceiling
        }

        map[interval[START]] = interval
    }

    fun getIntervals(): Array<IntArray> = map.values.toTypedArray()
}

fun main() {
    var summaryRanges = SummaryRanges()
    summaryRanges.addNum(1)
    summaryRanges.getIntervals().forEach { print(it.contentToString()) }
    summaryRanges.addNum(3)
    println()
    summaryRanges.getIntervals().forEach { print(it.contentToString()) }
    println()
    summaryRanges.addNum(7)
    summaryRanges.getIntervals().forEach { print(it.contentToString()) }
    println()
    summaryRanges.addNum(2)
    summaryRanges.getIntervals().forEach { print(it.contentToString()) }
    println()
    summaryRanges.addNum(6)
    summaryRanges.getIntervals().forEach { print(it.contentToString()) }
}