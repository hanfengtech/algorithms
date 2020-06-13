package tech.hanfeng.algorithms.array

// O(N)
fun sortedSquares(A: IntArray): IntArray {
    var out = IntArray(A.size)
    var start = 0
    var end = A.size - 1
    var index = A.size - 1
    while (start <= end) {
        val S = A[start] * A[start]
        val E = A[end] * A[end]
        if (S > E) {
            out[index] = S
            start++
        } else {
            out[index] = E
            end--
        }
        index--
    }
    return out
}

fun main() {
    println(sortedSquares(intArrayOf(-4,-1,0,3,10)).contentToString())
}