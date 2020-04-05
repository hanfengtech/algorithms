package tech.hanfeng.algorithms.array

fun maxProfit(prices : IntArray) : Int {
    var localMax = 0
    var max = 0

    for (i in 1 until prices.size) {
        localMax += prices[i] - prices[i -1]
        localMax = Math.max(0, localMax)
        max = Math.max(max, localMax)
    }

    return max
}

fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
}