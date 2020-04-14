package tech.hanfeng.algorithms.array

import java.util.*


fun findMaxLength(nums: IntArray): Int {
    val map: MutableMap<Int, Int> = HashMap()
    map[0] = -1
    var max = 0
    var sum = 0
    for (i in nums.indices) {
        sum += if (nums[i] == 1) 1 else -1
        if (map.contains(sum)) {
            max = Math.max(max, i - map[sum]!!)
        } else {
            map[sum] = i
        }
    }
    return max
}

fun main() {
    println(findMaxLength(intArrayOf(0,0,0,1,1,1)))
    println(findMaxLength(intArrayOf(0,1,0,0,1,1,0)))
    println(findMaxLength(intArrayOf(1,1,0,0,1,1,0,0,1,0,0,1,1,0)))
    println(findMaxLength(intArrayOf(0,0,0,0,0,0,0)))
}