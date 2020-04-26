package tech.hanfeng.algorithms.greedy

fun canJump(A : IntArray) : Boolean {
    var lastPos = A.size - 1
    for (i in A.size - 2 downTo 0) {
        if (i + A[i] >= lastPos) {
            lastPos = i
        }
    }

    return lastPos == 0
}

fun main() {
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
}