package tech.hanfeng.algorithms.dp


fun climbingStairs(n : Int) : Int {
    if (n <= 2) return n

    val dp = IntArray(n)
    dp[0] = 1
    dp[1] = 2

    for (i in 2 until n) {
        dp[i] = dp[i - 2] + dp[i - 1]
    }
    return dp[n-1]
}

fun climbingStairsS(n : Int) : Int {
    if (n <= 2) return n

    var result = 2
    var preResult = 1
    var tmp : Int
    for (i in 3 .. n) {
        tmp = result
        result += preResult
        preResult = tmp
    }

    return result
}

fun main() {
    println(climbingStairs(2))
    println(climbingStairs(5))
    println(climbingStairsS(5))
    println(climbingStairs(1000))
}