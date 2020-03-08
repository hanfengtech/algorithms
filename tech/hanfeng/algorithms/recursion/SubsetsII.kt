package tech.hanfeng.algorithms.recursion

import java.util.*
import kotlin.collections.ArrayList

fun subsetsII(nums : IntArray) : List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    Arrays.sort(nums)

    fun backtrack(slate : ArrayList<Int>, start : Int) {
        resList.add(slate.toList())
        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i - 1]) continue  // skip duplicates
            slate.add(nums[i])
            backtrack(slate, i + 1)
            slate.removeAt(slate.lastIndex)
        }
    }

    backtrack(ArrayList(), 0)

    return resList
}

fun main() {
    println(subsetsII(intArrayOf(1,2,2)))
}