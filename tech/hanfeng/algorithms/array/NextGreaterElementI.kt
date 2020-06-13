package tech.hanfeng.algorithms.array

import java.util.*
import kotlin.collections.HashMap

fun nextGreaterElementI(nums1 : IntArray, nums2 : IntArray) :  IntArray {
    var map = HashMap<Int, Int>(nums2.size)
    var stack = LinkedList<Int>()
    var result = IntArray(nums1.size)

    nums2.forEach {
        while (stack.size > 0 && stack.peek() < it) map[stack.pop()] = it
        stack.push(it)
    }

    for(i in nums1.indices)
        result[i] = map.getOrDefault(nums1[i], -1)

    return result
}

fun main() {
    println(nextGreaterElementI(intArrayOf(4,1,2), intArrayOf(1,3,4,2)).contentToString())
}