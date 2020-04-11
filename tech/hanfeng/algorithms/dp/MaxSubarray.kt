package tech.hanfeng.algorithms.dp

fun maxSubArray(A : IntArray) : Int {
    var n = A.size

    val dp = IntArray(n)
    dp[0] = A[0]
    var max = dp[0]

    for (i in 1 until n) {
        dp[i] = A[i] + if (dp[i - 1] > 0) dp[i - 1] else 0
        max = Math.max(max, dp[i])
    }
    return max
}

fun maxSubArrayS(nums: IntArray) : Int {
    var n = nums.size

    var max = nums[0]
    var localMax = max

    for (i in 1 until n) {
        localMax = nums[i] + if (localMax > 0) localMax else 0
        max = Math.max(max, localMax)
    }
    return max
}

fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(maxSubArrayS(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}