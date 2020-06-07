package tech.hanfeng.algorithms.dp

class Fibonacci{

    fun fib(n : Int) : Int {
        if (n == 0) return 0
        if (n == 1) return 1
        return fib(n - 1) + fib(n - 2)
    }

    fun fibM(n : Int) : Int {
        val cache = IntArray(n + 1) {-1}
        cache[0] = 0
        cache[1] = 1

        fun helper(n : Int) : Int {
            if (cache[n] < 0) {
                cache[n] = helper(n - 1) + helper(n - 2)
            }
            return cache[n]
        }

        return helper(n)
    }

    fun fibDP(n : Int) : Int {
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1

        for (i in 2 .. n) {
            dp[i] = dp[i-1] + dp[i-2]
        }

        return dp[n]
    }

    fun fibDPO(n : Int) : Int {
        var prev = 0
        var curr = 1
        for (i in 2 .. n) {
            val tmp = curr
            curr += prev
            prev = tmp
        }
        return if (n > 0) curr else prev
    }
}

fun main() {
    val fib = Fibonacci()
    println(fib.fib(5))
    println(fib.fibM(10))
    println(fib.fibDP(20))
    println(fib.fibDPO(20))
    println(fib.fibDPO(0))
}