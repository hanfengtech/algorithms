package tech.hanfeng.algorithms.recursion

import kotlin.collections.ArrayList

/*
 Permutations without repetitions
 Swap the integer that has bean already process and recursively call the smaller set of the problem
 */
fun permutations(nums: IntArray) : List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    fun helper(slate : IntArray, i : Int) {
        if (slate.size == i) {
            resList.add(slate.toList())
            return
        }

        for (j in i until slate.size) {
            slate.swap(i, j)
            helper(slate, i + 1)
            slate.swap(j, i)
        }
    }

    helper(nums, 0)
    return resList
}

fun IntArray.swap(i : Int, j : Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

fun main() {
    println(permutations(intArrayOf(1,2,3)))
}