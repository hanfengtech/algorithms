package tech.hanfeng.algorithms.array

import java.util.*

data class PairInfo(var first : Int, var second : Int, var index : Int)   // index is the second number list index
fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    var k = k
    var res = mutableListOf<List<Int>>()
    if (nums1.isEmpty() || nums2.isEmpty() || k == 0) return res
    val pq = PriorityQueue<PairInfo> ( Comparator { a, b -> a.first + a.second - b.first - b.second } )
    for (i in 0 until minOf(nums1.size, k))
        pq.offer(PairInfo(nums1[i], nums2[0], 0))

    while(k-- > 0 && pq.isNotEmpty()) {
        val cur = pq.poll()
        res.add(listOf(cur.first + cur.second))
        if (cur.index == nums2.size - 1) continue
        val j = cur.index + 1
        pq.offer(PairInfo(cur.first, nums2[j], j))
    }
    return res
}