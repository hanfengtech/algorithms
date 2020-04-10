package tech.hanfeng.algorithms.array

import java.util.*
import kotlin.collections.ArrayList

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val n = nums1.size
    val m = nums2.size

    if (n == 0 || m == 0)
        return IntArray(0)

    Arrays.sort(nums1)
    Arrays.sort(nums2)

    val result = ArrayList<Int>()
    var i = 0
    var j = 0

    while(i < n && j < m) {
        when {
            nums1[i] == nums2[j] -> {
                result.add(nums1[i])
                i++
                j++
            }
            nums1[i] < nums2[j] -> {
                i++
            }
            else -> {
                j++
            }
        }
    }

    return result.toIntArray()
}

fun main() {
    println(intersect(intArrayOf(1,2,2,1), intArrayOf(2,2)).contentToString())
    println(intersect(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).contentToString())
}