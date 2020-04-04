package tech.hanfeng.algorithms.dp

fun maxSubArray(A : IntArray) : Int {
    var n = A.size

    val dp = IntArray(n) {0}
    dp[0] = A[0]
    var max = dp[0]

    for (i in 1 until n) {
        dp[i] = A[i] + if (dp[i - 1] > 0) dp[i - 1] else 0
        max = Math.max(max, dp[i])
    }
    return max
}

fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}