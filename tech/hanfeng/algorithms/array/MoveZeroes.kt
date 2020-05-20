package tech.hanfeng.algorithms.array

fun moveZeros(A : IntArray) {
    val n = A.size
    if (n == 0) return
    var i = 0
    for (j in 0 until n) {
        if (A[j] != 0) {
            A[i++] = A[j]
        }
    }

    while (i < n) {
        A[i++] = 0
    }
}

fun moveZerosSwap(A: IntArray) {
    var j = A.size - 1
    if (j < 0) return

    while(A[j] == 0) {
        j--
    }

    var i = 0
    while (i < j) {
        if (A[i] == 0) {
            A[i] = A[j]
            A[j] = 0
            j--
        }
        i++
    }
}

fun main() {
    val a = intArrayOf(0,1,0,3,12,0,0)
    moveZeros(a)
    println(a.contentToString())
}