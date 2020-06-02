package tech.hanfeng.algorithms.array

fun mergeIntervals(intervals : Array<IntArray>) : Array<IntArray> {
    val merge = ArrayList<IntArray>()
    intervals.sortBy { it[0] }

    intervals.forEach {
        if (merge.isEmpty() || merge.last()[1] < it[0]) {
            merge.add(it)
        } else {  // merge
            merge.last()[1] = Math.max(merge.last()[1], it[1])
        }
    }

    return merge.toTypedArray()
}

fun main() {
    val intervals = arrayOf(intArrayOf(1,3), intArrayOf(2,6),intArrayOf(8,10),intArrayOf(15,18))
    val result = mergeIntervals(intervals)

    println(result.joinToString { it.contentToString() })


    val intervals2 = arrayOf(intArrayOf(1,4), intArrayOf(4,5))
    val result2 = mergeIntervals(intervals2)

    println(result2.joinToString { it.contentToString() })
}