package tech.hanfeng.algorithms.array

fun getSubarraySumIndex(nums: IntArray, k : Int) : IntArray? {
    var i = 0
    var j = 0
    var sum = 0

    while(j < nums.size) {
        sum += nums[j]

        while(sum > k) {
            sum -= nums[i++]
        }

        if (sum == k) {
            return intArrayOf(i+1, j+1)
        }

        j++
    }
    return null
}

fun main() {
    println(getSubarraySumIndex(intArrayOf(1, 2, 3, 7, 5), 12)?.contentToString())
    println(getSubarraySumIndex(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 15)?.contentToString())
}