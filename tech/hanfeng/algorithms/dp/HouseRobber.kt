package tech.hanfeng.algorithms.dp

//Input: [1,2,3,1]
fun rob(nums : IntArray) : Int {
    if (nums.isEmpty()) return 0
    val n = nums.size

    val dp = IntArray(n + 1)

    var i = 1
    nums.forEach {
        val tmp = dp[i-1]
        dp[i - 1] = Math.max(dp[i - 1], dp[i])
        dp[i] = it + tmp
    }

    return Math.max(dp[i-1], dp[i])
}

fun robS(nums : IntArray) : Int {
    var prevNo = 0
    var prevYes = 0

    nums.forEach {
        val temp = prevNo
        prevNo = Math.max(prevNo, prevYes)
        prevYes = it + temp
    }

    return Math.max(prevNo, prevYes)
}

fun robDP(nums : IntArray) : Int {
    if (nums.isEmpty()) return 0
    val n = nums.size
    if (n == 1) return nums[0]

    val dp = IntArray(n)
    dp[0] = nums[0]
    dp[1] = Math.max(nums[0], nums[1])
    for (i in 2 until n) {
       dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
    }

    return dp[n - 1]
}

fun main() {
    println(rob(intArrayOf(1,2,3,1)))
    println(rob(intArrayOf(1,2)))
    println(rob(intArrayOf(1)))
    println(rob(intArrayOf()))
    println(rob(intArrayOf(2,7,9,3,1)))

    println(robDP(intArrayOf(2,1,1,2)))
    println(robS(intArrayOf(2,1,1,1,1,1,2)))
}