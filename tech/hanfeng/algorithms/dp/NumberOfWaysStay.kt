package tech.hanfeng.algorithms.dp

private const val MOD = 1e9.toInt() + 7

// O(n * min(n, m)) time and O(min(n, m)) space
fun numWays(steps: Int, arrLen: Int): Int {
    val dp = IntArray(minOf(arrLen, steps + 1) + 1)
    dp[0] = 1
    for (step in 1..steps) {
        var previous = 0
        for (i in 0 until minOf(arrLen, step + 1)) {
            val current = dp[i]
            dp[i] = ((previous + current) % MOD + dp[i + 1]) % MOD
            previous = current
        }
    }
    return dp[0]
}

fun main() {
    println(numWays(3,2))
    println(numWays(3,4))
    println(numWays(3,1))
    println(numWays(1,1))

    println(numWays(4,2))
    println(numWays(4,3))

    println()
    println(numWays(2,2))
    println(numWays(2,4))

    println(numWays(100,10))
}