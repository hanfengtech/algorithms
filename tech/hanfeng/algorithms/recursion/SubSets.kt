package tech.hanfeng.algorithms.recursion

import java.util.*


/*
  O(2^N)
 */
fun subsetsR(nums: IntArray): List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    fun helper(S : IntArray, i : Int, slate : LinkedList<Int>) {
        if (i == S.size) {
            resList.add(slate.toList())
        } else {
            slate.add(S[i])
            helper(S, i + 1, slate) // include
            slate.removeLast()
            helper(S, i + 1, slate) // exclude
        }
    }

    helper(nums, 0, LinkedList())

    return resList
}

/*
  O(N)
 */
fun subsets(nums: IntArray): List<List<Int>>? {
    val resList = ArrayList<List<Int>>()
    fun helper(nums: IntArray, start: Int, slate: LinkedList<Int>) {
        resList.add(slate.toList())
        println(slate)
        for (i in start until nums.size) {
            slate.add(nums[i])
            helper( nums, i + 1, slate)
            slate.removeLast()
        }
    }

    helper(nums, 0, LinkedList())
    return resList
}




fun main() {
    println(subsetsR(intArrayOf(1,2,3)))
    println(subsets(intArrayOf(1,2,3)))
}