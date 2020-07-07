package tech.hanfeng.algorithms.bitwise

fun minKBitFlips(A : IntArray, K : Int) : Int {
    val n = A.size
    val hint = IntArray(n)
    var ans = 0
    var flip = 0
    for (i in A.indices) {
        if (hint[i] == 1) flip = 1 - flip
        if (A[i] == flip) {
            ans++
            var j = i + K
            if (j > n) return -1
            flip = 1 - flip
            if (j < n) hint[j] = 1
        }
    }
    return ans
}

fun main() {
    println(minKBitFlips(intArrayOf(0,1,0), 1))
    println(minKBitFlips(intArrayOf(1,1,0), 2))
}