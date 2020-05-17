package tech.hanfeng.algorithms.array

import java.util.*


fun findLargestFibSubsequence(A: IntArray): List<Int> {
    val result = ArrayList<Int>()
    val max: Int = Collections.max(A.asList())
    val fibs = getFibs(max)
    A.forEach {
        if (fibs.contains(it)) {
            result.add(it)
        }
    }

    return result
}

fun getFibs(max : Int) : HashSet<Int> {
    var a = 0
    var b = 1
    var c = 1

    val result = HashSet<Int>()
    result.add(a)
    result.add(b)

    while (c < max) {
        a = b
        b = c
        c = a + b
        result.add(c)
        println(c)
    }
    return result
}

fun main() {
    println(findLargestFibSubsequence(intArrayOf(0, 2, 8, 5, 2, 1, 4, 13, 23)))
}