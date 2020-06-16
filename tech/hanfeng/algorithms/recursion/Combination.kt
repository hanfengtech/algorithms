package tech.hanfeng.algorithms.recursion

import java.util.*


fun combination(n : Int, k : Int) : Int = if (n <= 1 || k == 0 || k == n) 1
      else combination(n - 1, k) + combination(n - 1, k - 1)

fun combine(n: Int, k: Int): List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    if (n <= 0 || n < k)
        return resList

    fun helper(slate : ArrayList<Int>, start : Int)  {
        if (slate.size == k) {
            resList.add(slate.toList())
            return
        }

        for (i in start..n) {
            slate.add(i)
            helper(slate, i + 1)
            slate.removeAt(slate.lastIndex)
        }
    }

    helper(ArrayList(), 1)
    return resList
}

fun main() {
    println(combination(4, 2))
    println(combine(4, 3))
}