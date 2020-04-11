package tech.hanfeng.algorithms.dp

fun maxProfitS(prices : IntArray) : Int {
    var localMax = 0
    var max = 0

    for (i in 1 until prices.size) {
        localMax += prices[i] - prices[i -1]
        localMax = Math.max(0, localMax)
        max = Math.max(max, localMax)
    }

    return max
}

fun maxProfit(prices: IntArray) : Int {
    var max = 0
    val dp = IntArray(prices.size)
    dp[0] = max

    for (i in 1 until prices.size) {
        dp[i] = dp[i-1] + (prices[i] - prices[i - 1])
        dp[i] = Math.max(0, dp[i])
        max = Math.max(max, dp[i])
    }
    return max
}

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfitS(intArrayOf(7, 1, 5, 3, 6, 4)))
}