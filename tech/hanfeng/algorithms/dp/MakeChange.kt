package tech.hanfeng.algorithms.dp

class MakeChange {

    private val coins = intArrayOf(25,10,5,1)

    fun makeChanges(c : Int) : Int {
        if (c == 0) return 0

        var minCoins = Int.MAX_VALUE

        for (coin in coins) {
            if (c - coin >= 0) {
                val currMinCoins = makeChanges(c - coin)
                minCoins = Math.min(minCoins, currMinCoins)
            }
        }
        return minCoins + 1
    }


    fun makeChangesM(c : Int) : Int {
        val cache = IntArray(c + 1) { -1 }
        cache[0] = 0

        fun helper(c : Int) : Int {
            if (cache[c] > -1) return cache[c]
            var minCoins = Int.MAX_VALUE

            for (coin in coins) {
                if (c - coin >= 0) {
                    val currMinCoins = helper(c - coin)
                    minCoins = Math.min(minCoins, currMinCoins)
                }
            }
            cache[c] = minCoins + 1
            return cache[c]
        }

        return helper(c)
    }

    fun makeChangesDP(c : Int) : Int {
        val dp = IntArray(c + 1)

        for (i in 1 .. c) {
            var minCoins = Int.MAX_VALUE
            for (coin in coins) {
                if (i - coin >= 0) {
                    var currCoins = dp[i - coin] + 1
                    minCoins = Math.min(minCoins, currCoins)
                }
            }
            dp[i] = minCoins
        }
        return dp[c]
    }

    fun coinChange(coins: IntArray, amount: Int): Int {
        val max = amount + 1
        val dp = IntArray(max) { max }
        dp[0] = 0

        for (i in 1 .. amount) {
            for (coin in coins) {
                 if (coin <= i) {
                     dp[i] = Math.min(dp[i], dp[i - coin] + 1)
                 }
            }
        }
        return if (dp[amount] > amount) -1 else dp[amount]
    }
}

fun main() {
    val mc = MakeChange()
    println(mc.makeChanges(1))
    println(mc.makeChanges(6))
    println(mc.makeChanges(25))
    println(mc.makeChanges(49))
    println(mc.makeChangesM(49))
    println(mc.makeChangesDP(49))

   // println(mc.coinChange(intArrayOf(1,2,5), 11))
   // println(mc.coinChange(intArrayOf(2), 3))

    println(mc.coinChange(intArrayOf(186,419,83,408), 6249))
}