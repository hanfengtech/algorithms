package tech.hanfeng.algorithms.array

fun maxProfitII(prices : IntArray) : Int {
    var total = 0

    for (i in 0 until prices.size - 1) {
        if (prices[i + 1] > prices[i]) {
            total += prices[i + 1] - prices[i]
        }
    }
    return total
}

fun main() {
    println(maxProfitII(intArrayOf(7,1,5,3,6,4)))
}