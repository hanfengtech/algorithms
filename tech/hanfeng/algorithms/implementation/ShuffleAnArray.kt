package tech.hanfeng.algorithms.implementation

import java.util.*

//Fisher-Yates Algorithm

class Solution(nums: IntArray) {

    private val original : IntArray = nums.clone()
    private val array = nums
    private val rand = Random()

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        for (i in original.indices) {
            array[i] = original[i]
        }
        return array
    }

    fun randInt(low : Int, high : Int) : Int {
        if (low == high) return low
        return low + rand.nextInt(high - low)
    }

    fun swap(nums: IntArray, i : Int, j : Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        for (i in array.indices) {
            val j = randInt(i, array.size)
            swap(array, i, j)
        }

        return array
    }
}

fun main() {
    val s = Solution(intArrayOf(1,2,3,4))
    println(s.shuffle().contentToString())
}