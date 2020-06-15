package tech.hanfeng.algorithms.dp

fun lengthOfLIS(nums: IntArray): Int {
    if (nums.size == 0) return 0

    var dp = IntArray(nums.size)
    dp[0] = 1
    var max = 1
    for (i in 1 until dp.size) {
        var localmax = 0
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                localmax = maxOf(localmax, dp[j])
            }
        }
        dp[i] = localmax + 1
        max = maxOf(max, dp[i])
    }
    return max
}

fun main() {
    println(lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
}