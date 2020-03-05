package tech.hanfeng.algorithms.recursion

import java.util.*
import kotlin.collections.ArrayList

fun combinationSumII(candidates : IntArray, target : Int) : List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    if (candidates.isEmpty()) return resList

    fun helper(slate : ArrayList<Int>, remaining : Int, start : Int) {
        if (remaining < 0) return
        if (remaining == 0) {
            resList.add(slate.toList())
            return
        }

        for (i in start until candidates.size) {
            if (i > start && candidates[i] == candidates[i-1]) continue  // skip same candidates
            slate.add(candidates[i])
            helper(slate, remaining - candidates[i], i + 1)
            slate.removeAt(slate.lastIndex)
        }
    }

    Arrays.sort(candidates)
    helper(ArrayList(), target, 0)
    return resList
}

fun main() {
    println(combinationSumII(intArrayOf(10,1,2,7,6,1,5), 8))
}