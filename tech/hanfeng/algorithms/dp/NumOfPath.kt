package tech.hanfeng.algorithms.dp

class NumOfPath {

    fun numberOfPath(n : Int, m : Int) : Int {
        if (n == 1 || m == 1) return 1
        return numberOfPath(n - 1, m) + numberOfPath(n, m - 1)
    }

    fun numberOfPathM(n : Int, m : Int) : Int {
        val cache = Array(n + 1) { IntArray(m + 1) }

        fun helper(n : Int, m : Int) : Int {
            if (cache[n][m] != 0) return cache[n][m]

            if (n == 1 || m == 1) {
                cache[n][m] = 1
                return cache[n][m]
            }

            cache[n][m] = helper(n - 1, m) + helper(n, m - 1)
            return cache[n][m]
        }

        return helper(n,m)
    }

    fun numberOfPathDP(n : Int, m : Int) : Int {
        val dp = IntArray(m) { 1 }
        for (i in 1 until n) {
            for (j in 1 until m) {
                dp[j] = dp[j-1]+dp[j]
            }
        }
        return dp[m - 1]
    }
}

fun main() {
    println(NumOfPath().numberOfPath(2,2))
    println(NumOfPath().numberOfPathM(2,2))
    println(NumOfPath().numberOfPathDP(2,2))
}