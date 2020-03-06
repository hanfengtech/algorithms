package tech.hanfeng.algorithms.recursion

import java.util.*
import kotlin.collections.ArrayList


fun combinationSumIV(nums: IntArray, target : Int) : List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    if (nums.isEmpty()) return resList

    fun helper(slate : ArrayList<Int>, remaining : Int, start : Int) {
        if (remaining < 0) return
        if (remaining == 0) {
            resList.add(slate.toList())
            return
        }

        for (i in start until nums.size) {
            slate.add(nums[i])
            helper(slate, remaining - nums[i], start)
            slate.removeAt(slate.lastIndex)
        }
    }

    helper(ArrayList(), target, 0)
    return resList
}

fun combinationSum4(nums: IntArray, target: Int): Int {
    var count = 0
    if (nums.isEmpty()) return count

    fun helper(slate : ArrayList<Int>, remaining : Int, start : Int) {
        if (remaining < 0) return
        if (remaining == 0) {
            count++
            return
        }

        for (i in start until nums.size) {
            slate.add(nums[i])
            helper(slate, remaining - nums[i], start)
            slate.removeAt(slate.lastIndex)
        }
    }

    helper(ArrayList(), target, 0)
    return count
}

fun combinationSum4It(nums: IntArray, target: Int): Int {
    var dp = IntArray(target + 1)
    Arrays.fill(dp, -1)

   fun getCombination(nums: IntArray, target: Int, sum: Int): Int {
        if (dp[sum] != -1) return dp[sum]
        if (sum == target) return 1
        var count = 0
        for (num in nums) {
            if (sum + num <= target) count += getCombination(nums, target, sum + num)
        }
        dp[sum] = count
        return dp[sum]
    }

    return getCombination(nums, target, 0)
}

fun combinationSum4dp(nums: IntArray, target: Int): Int {
    val comb = IntArray(target + 1)
    comb[0] = 1
    for (i in 1 until comb.size) {
        for (j in nums.indices) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]]
            }
        }
    }
    return comb[target]
}



fun main() {
    println(combinationSum4dp(intArrayOf(1,2,3), 32))
    println(combinationSumIV(intArrayOf(1,2,3), 4))
}