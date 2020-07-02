package tech.hanfeng.algorithms

// 1,2,3,4,5,3,2

// 1,2,3,4

fun validMountainArray(A: IntArray) : Boolean {
    var n = A.size
    var i = 0

    while (i + 1 < n && A[i] < A[i + 1]) i++    // walking up hill

    if (i == 0 || i == n - 1) return false

    while (i + 1 < n && A[i] > A[i + 1]) i++    // walking down hill

    return i == n - 1   // if not the last item, then we found a mountain array
}


fun validMountainArray2(A: IntArray) : Boolean {
    var n = A.size
    var i = 0

    while (i + 1 < n && A[i] < A[i + 1]) i++    // walking up hill

    if (i == 0 || i == n - 1) return false

    while (i + 1 < n && A[i] > A[i + 1]) i++    // walking down hill

    return i == n - 1   // if not the last item, then we found a mountain array
}

fun main() {
    println(validMountainArray(intArrayOf(1,2,3,4,5,3,2)))
    println(validMountainArray(intArrayOf(1,2,3,4)))
    println(validMountainArray(intArrayOf(1,2,3,4,5,3,2, 1,2,3)))
    println(validMountainArray(intArrayOf(1)))
    println(validMountainArray(intArrayOf(1,2,2,3,4,5,3,2)))
}