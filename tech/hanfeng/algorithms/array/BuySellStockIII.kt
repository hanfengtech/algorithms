package tech.hanfeng.algorithms.array

fun maxProfitIII(prices : IntArray?) : Int {
    var hold1 = Integer.MIN_VALUE
    var hold2 = Integer.MIN_VALUE
    var release1 = 0
    var release2 = 0

    prices?.forEach {
        release2 = Math.max(release2, hold2 + it)
        hold2 = Math.max(hold2, release1 - it)
        release1 = Math.max(release1, hold1 + it)
        hold1 = Math.max(hold1, -it)
    }

    return release2
}

fun main() {
    println(maxProfitIII(intArrayOf(7,1,5,3,6,4)))
}