package tech.hanfeng.algorithms.array

import java.util.*

fun lastStoneWeight(stones : IntArray) : Int {

    if (stones.isEmpty()) return 0
    if (stones.size == 1) return stones[0]

    var yIndex = stones.size - 1
    var xIndex = yIndex - 1

    while (xIndex >= 0) {
        Arrays.sort(stones, 0, yIndex + 1)
        stones[xIndex] = stones[yIndex] - stones[xIndex]
        yIndex--
        xIndex--
    }

    return stones[0]
}

fun lastStoneWeightHeap(stones : IntArray) : Int {
    // val queue = PriorityQueue<Int>{ a, b -> a - b}   // min heap
    val maxHeap = PriorityQueue<Int>{ a, b -> b - a}   // max heap
    for (s in stones) {
        maxHeap.offer(s)
    }

    while (maxHeap.isNotEmpty()) {
        val x = maxHeap.poll()
        if (maxHeap.isEmpty())
            return x
        val y = maxHeap.poll()
        if (x == y) continue
        maxHeap.offer(if (x - y > 0) x - y else y - x)
    }

    return 0
}

fun main() {
    println(lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
    println(lastStoneWeightHeap(intArrayOf(2,7,4,1,8,1)))
}