package tech.hanfeng.algorithms.dp

fun superEggDrop(K: Int, N: Int): Int {  // rolling with "drops" dp[i][j] = no of floors we can measure with i eggs and j drops
    var prev = IntArray(K + 1)     // dp[i][j] = 1 + dp[i-1][j-1] + dp[i][j-1]
    var dp = IntArray(K + 1)
    var drops = 1
    while (true) {
        for (i in 1..K)
            dp[i] = prev[i - 1] + prev[i] + 1
        if (dp[K] >= N) return drops
        drops++
        val tmp = prev
        prev = dp
        dp = tmp
    }
}

fun main() {
    println(superEggDrop(3,4))
    println(superEggDrop(1,6))
    println(superEggDrop(2,6))
    println(superEggDrop(5,6))
}