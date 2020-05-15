package tech.hanfeng.algorithms.array

import java.util.*

fun findAllSumPairs(A : IntArray, B : IntArray, k : Int) : List<Pair<Int, Int>>? {
    if (A.isEmpty() || B.isEmpty()) return null
    val set = HashSet<Int>()
    A.forEach { set.add(it) }

    var resultList = ArrayList<Pair<Int, Int>>()

    B.forEach {
        val complement = k - it
        if (set.contains(complement)) {
            resultList.add(Pair(complement, it))
        }
    }

    return resultList.sortedBy { it.first }
}

fun main() {
    var list = findAllSumPairs(intArrayOf(1, 2, 4, 5, 7), intArrayOf(5, 6, 3, 4, 8), 9)

    list?.forEachIndexed { index, pair ->
        print("${pair.first} ${pair.second}")
        if (index < list!!.size - 1) {
            print(", ")
        }
    }
    println()


    list = findAllSumPairs(intArrayOf(0,2), intArrayOf(1,3), 3)

    list?.forEachIndexed { index, pair ->
        print("${pair.first} ${pair.second}")
        if (index < list.size - 1) {
            print(", ")
        }
    }
    println()

}