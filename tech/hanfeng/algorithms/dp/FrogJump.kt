package tech.hanfeng.algorithms.dp

import java.util.*

class FrogJump {

    fun canCross(stones: IntArray) : Boolean {
        val n: Int = stones.size
        val dp = Array(n) { BooleanArray(n) }

        dp[0][1] = true // when you are standing at stones[0], next you can only jump 1step to next stone.

        for (i in 1 until n) {
            for (j in i - 1 downTo 0) {
                val diff = stones[i] - stones[j]               // get the different of two stones
                if (diff in 0 until n && dp[j][diff]) {        // check the previous step contains the diff jumps
                    if (i == n - 1) return true                // if able to reach the last stone, simply return true
                    dp[i][diff] = true                         // set all possible jumps
                    if (diff - 1 >= 0) dp[i][diff - 1] = true
                    if (diff + 1 <= n) dp[i][diff + 1] = true
                }
            }
        }

        return false
    }

    fun canCrossSet(stones: IntArray): Boolean {
        val n = stones.size
        val lastIndex = n - 1
        val list = ArrayList<HashSet<Int>>()  // list to store all possible jump units set
        var possibleJumps = HashSet<Int>()    // store all possible jump units
        possibleJumps.add(1)                  // there is only one possible unit at the beginning
        list.add(possibleJumps)
        for (i in 1 until n) {
            possibleJumps = HashSet()
            for (j in i - 1 downTo 0) {
                val diff = stones[i] - stones[j]     // calculate the diff
                if (list[j].contains(diff)) {        // does the diff exist in previous possible unit set
                    if (list.size == lastIndex) return true    // if size of the list is equals to lastIndex meaning we are able to reach the last stone
                    possibleJumps.add(diff)                    // add all diffs to the possible units
                    possibleJumps.add(diff + 1)
                    possibleJumps.add(diff - 1)
                }
            }
            list.add(possibleJumps)
        }
        return list[lastIndex].size > 0
    }
}

fun main() {
    println(FrogJump().canCross(intArrayOf(0,1,3,6,10,13,14)))
    println(FrogJump().canCross(intArrayOf(0,1,3,5,6,8,12,17)))
    println(FrogJump().canCross(intArrayOf(0,1,2,3,4,8,9,11)))

    println(FrogJump().canCrossSet(intArrayOf(0,1,3,5,6,8,12,17)))
}