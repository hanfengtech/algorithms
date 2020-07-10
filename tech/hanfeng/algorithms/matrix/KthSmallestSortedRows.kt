package tech.hanfeng.algorithms.matrix

import java.util.*

data class PairInfo(var first : Int, var second : Int, var index : Int)   // index is the second number list index
fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
    val m = mat.size
    return solve(0, m - 1, mat, k)[k - 1]
}

private fun solve(i: Int, j: Int, mat: Array<IntArray>, k: Int): List<Int> {
    if (i == j) return mat[i].toList()
    val mid = i + (j - i) / 2
    val l1 = solve(i, mid, mat, k)
    val l2 = solve(mid + 1, j, mat, k)
    return kSmallestPairs(l1, l2, k)
}

// code from LC 373
private fun kSmallestPairs(nums1: List<Int>, nums2: List<Int>, k: Int): List<Int> {
    var k = k
    val res = ArrayList<Int>()
    if (nums1.isEmpty() || nums2.isEmpty() || k == 0) return res
    val pq = PriorityQueue<PairInfo> ( Comparator { a, b -> a.first + a.second - b.first - b.second } )
    for (i in 0 until minOf(nums1.size, k))
        pq.offer(PairInfo(nums1[i], nums2[0], 0))

    while (k-- > 0 && !pq.isEmpty()) {
        val cur = pq.poll()
        res.add(cur.first + cur.second)
        if (cur.index == nums2.size - 1) continue
        val j = cur.index + 1
        pq.offer(PairInfo(cur.first, nums2[j], j))
    }
    return res
}

// slow and use more space, but easy implementation
fun kthSmallestDP(mat: Array<IntArray>, k: Int): Int {
    val m = mat.size
    val n: Int = mat[0].size
    var pq = PriorityQueue<Int?>(Collections.reverseOrder())
    pq.offer(0)
    for (i in 0 until m) {
        val nq = PriorityQueue<Int?>(Collections.reverseOrder())
        for (sum in pq) {
            for (j in 0 until n) {
                nq.offer(sum?.plus(mat[i][j]))
                if (nq.size > k) nq.poll()
            }
        }
        pq = nq
    }
    return pq.poll()!!
}

fun main() {
    val matrix = arrayOf(intArrayOf(1,3,11), intArrayOf(2,4,6), intArrayOf(1,5,7))
    println(kthSmallest(matrix, 5))
}