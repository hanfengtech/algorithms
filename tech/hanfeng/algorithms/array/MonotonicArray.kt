package tech.hanfeng.algorithms.array

fun monotonicArray(A : IntArray) : Boolean {
    if (A.isEmpty() || A.size == 1) return true

    var inc = 0
    var dec = 0

    for (i in 1 until A.size) {
        if (A[i] >= A[i-1]) inc++
        if (A[i] <= A[i-1]) dec++
    }

    return A.size - 1 == inc || A.size - 1 == dec
}

fun isMonotonic0(A: IntArray): Boolean {
    if (A.isEmpty() || A.size == 1) return true

    var direction = 0

    for (i in 1 until A.size) {
        if (A[i] - A[i - 1] > 0) {  // increasing
            if (direction == -1) {
                return false
            } else {
                direction = 1
            }
        } else if (A[i] - A[i - 1] < 0) {  // decreasing
            if (direction == 1) {
                return false
            } else {
                direction = -1
            }
        }
    }

    return true
}

fun main() {
    println(monotonicArray(intArrayOf(1,2,2,3)))
}