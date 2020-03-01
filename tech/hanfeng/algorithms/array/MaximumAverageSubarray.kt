package tech.hanfeng.algorithms.array

import java.lang.IllegalArgumentException
import kotlin.math.max

fun maxAverageSubarray(A : IntArray, k : Int) : Double {
    if (A.isEmpty()) return 0.0
    if (k > A.size) throw IllegalArgumentException("k MUST be smaller than the given array size")
    if (k <= 0 || k > 30000) throw IllegalArgumentException("k MUST be greater than 0 and less than 30,000")
    if (A.size < -10000 || A.size > 10000) throw IllegalArgumentException("Array size MUST be in range of -10000 and 10000")

    var maxSum = 0
    for (i in 0 until k)
        maxSum += A[i]

    var tmpSum = maxSum
    for (j in k until A.size) {
        tmpSum += A[j] - A[j - k]
        maxSum = max(maxSum, tmpSum)
    }

    return maxSum.toDouble() / k
}

fun main() {
    println(maxAverageSubarray(intArrayOf(1,12,-5,-6,50,3), 4))
    println(maxAverageSubarray(intArrayOf(1,12,-5,-6,50,3), 1))

    try {
        print(maxAverageSubarray(intArrayOf(1, 12, -5, -6, 50, 3), 0))
    } catch (e : IllegalArgumentException) {
        e.printStackTrace()
    }

    try {
        print(maxAverageSubarray(intArrayOf(1, 12, -5, -6, 50, 3), 12))
    } catch (e : IllegalArgumentException) {
        e.printStackTrace()
    }

}