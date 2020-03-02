package tech.hanfeng.algorithms.recursion

import tech.hanfeng.algorithms.tree.minDepth

fun binarySearchR(A : IntArray, target : Int) : Boolean {
    var mid = 0

    fun helper(A : IntArray, s : Int, e : Int) : Boolean {
        if (A.isEmpty()) return false

        if (mid >= s) {
            mid = (s + e) / 2

            return when {
                A[mid] == target -> {
                    true
                }
                target < A[mid] -> {
                    helper(A, s, mid - 1)
                }
                else -> {
                    helper(A, mid + 1, e)
                }
            }
        }
        return false
    }

    return helper(A, 0, A.size)
}

fun binarySearch(A : IntArray, target : Int) : Boolean {

    fun helper(A : IntArray, s : Int, e : Int) : Boolean {
        if (A.isEmpty()) return false

        var mid = 0
        var i = s
        var j = e

        while (mid >= i) {
            mid = (i + j) / 2
            when {
                A[mid] == target -> {
                    return true
                }
                target < A[mid] -> {
                    j = mid - 1
                }
                else -> {
                    i = mid + 1
                }
            }
        }

        return false
    }

    return helper(A, 0, A.size)
}

fun main() {
    println(binarySearchR(intArrayOf(1,4,7,9,15,26,68,89), 100))
    println(binarySearch(intArrayOf(1,4,7,9,15,26,68,89), 100))
}
