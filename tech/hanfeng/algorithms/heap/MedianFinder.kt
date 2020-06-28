package tech.hanfeng.algorithms.heap

import java.util.*


class MedianFinder {
    var minHeap = PriorityQueue<Int>()
    var maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

    fun addNum3(num: Int) {
        if (minHeap.isEmpty() || num >= minHeap.peek()) {
            minHeap.add(num)
        } else {
            maxHeap.add(num)
        }

        // rebalancing
        if (minHeap.size > maxHeap.size && minHeap.size - maxHeap.size == 2) {
            maxHeap.add(minHeap.poll())
        } else if (minHeap.size < maxHeap.size && maxHeap.size - minHeap.size == 2) {
            minHeap.add(maxHeap.poll())
        }
    }

    fun findMedian3(): Double {
        return when {
            maxHeap.size > minHeap.size -> maxHeap.peek().toDouble()
            maxHeap.size < minHeap.size -> minHeap.peek().toDouble()
            else -> (maxHeap.peek() + minHeap.peek()) / 2.0
        }
    }

    fun addNum2(num: Int) {
        minHeap.add(num)
        maxHeap.add(minHeap.poll())
        if (maxHeap.size - minHeap.size >= 1) minHeap.add(maxHeap.poll())
    }

    fun findMedian2(): Double {
        return if (maxHeap.size == minHeap.size) (maxHeap.peek() + minHeap.peek()) / 2.0 else minHeap.peek().toDouble()
    }


    // Multiset solution
    private val tree = TreeMap<Int, Int>()
    private var totalCount = 0

    private var midValue = 0
    private var midIndex = 0

    fun addNum4(num: Int) {
        tree[num] = tree.getOrDefault(num, 0) + 1
        totalCount++
        if (totalCount == 1) {
            midValue = num
            midIndex = 0
        } else {
            if (num >= midValue) {
                midIndex++
                if (midIndex / 2 >= tree[midValue]!!) {
                    midValue = tree.higherKey(midValue)
                    midIndex = 0
                }
            } else {
                midIndex--
                if (midIndex < 0) {
                    midValue = tree.lowerKey(midValue)
                    midIndex = tree[midValue]!! * 2 - 1
                }
            }
        }
    }

    fun findMedian4(): Double {
        return if (totalCount % 2 == 0 && (midIndex + 1) / 2 >= tree[midValue]!!) {
            val nextMidValue = tree.higherKey(midValue)
            (midValue + nextMidValue) / 2.0
        } else {
            midValue.toDouble()
        }
    }


    // bucket sort for known small set of integer   If known the range of the integer, can improve by a fix number of buckets
    private var totalSize = 0
    private var buckets = LinkedList<LinkedList<Int>>()

    init {
        buckets.add(LinkedList())
    }

    fun addNum(num: Int) {
        var correctRange: MutableList<Int> = LinkedList()
        var targetIndex = 0

        // find the correct range to insert given num
        for (i in buckets!!.indices) {
            if (buckets!!.size == 1 ||
                    i == 0 && num <= buckets!![i].last ||
                    i == buckets!!.size - 1 && num >= buckets!![i].first ||
                    buckets!![i].first <= num && num <= buckets!![i].last ||
                    num > buckets!![i].last && num < buckets!![i + 1].first) {
                correctRange = buckets!![i]
                targetIndex = i
                break
            }
        }

        // put num at back of correct range, and sort it to keep increasing sequence
        totalSize++
        correctRange.add(num)
        correctRange.sort()

        // if currentRange's size > threshold, split it into two halves and add them back to buckets
        val len = correctRange.size
        if (len * len > totalSize) {
            val half1 = LinkedList(correctRange.subList(0, len / 2))
            val half2 = LinkedList(correctRange.subList(len / 2, len))
            buckets!![targetIndex] = half1 //replaces
            buckets!!.add(targetIndex + 1, half2) //inserts
        }
    }

    // iterate thru all ranges in buckets to find median value
    fun findMedian(): Double {
        if (totalSize == 0) return 0.0
        val mid1 = totalSize / 2
        val mid2 = mid1 + 1
        var leftCount = 0
        var first = 0.0
        var second = 0.0
        for (bucket in buckets!!) {
            if (leftCount < mid1 && mid1 <= leftCount + bucket.size)
                first = bucket[mid1 - leftCount - 1].toDouble()
            if (leftCount < mid2 && mid2 <= leftCount + bucket.size) {
                second = bucket[mid2 - leftCount - 1].toDouble()
                break
            }
            leftCount += bucket.size
        }
        return if (totalSize % 2 != 0) second else (first + second) / 2
    }
}

fun main() {
    val medianFinder = MedianFinder()

    medianFinder.addNum(1)
    medianFinder.addNum(2)
    println(medianFinder.findMedian())
    medianFinder.addNum(3)
    medianFinder.addNum(6)
    medianFinder.addNum(6)
    medianFinder.addNum(5)
    medianFinder.addNum(10)
    println(medianFinder.findMedian())

}