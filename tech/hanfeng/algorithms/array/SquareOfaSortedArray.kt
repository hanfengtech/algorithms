package tech.hanfeng.algorithms.array

// O(N)
fun sortedSquares(A: IntArray): IntArray {
    val res = IntArray(A.size)
    var i = 0
    var j = A.size - 1
    for (index in A.size - 1 downTo 0) {
        if (Math.abs(A[i]) > Math.abs(A[j])) {
            res[index] = A[i] * A[i]
            i++
        } else {
            res[index] = A[j] * A[j]
            j--
        }
    }
    return res
}

fun main() {
    println(sortedSquares(intArrayOf(-4,-1,0,3,10)).contentToString())
}