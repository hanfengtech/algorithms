package tech.hanfeng.algorithms.array

fun checkSubarraySumB(nums: IntArray, k: Int): Boolean {
    for (i in nums.indices) {
        var sum = 0
        var count = 0
        for (j in i until nums.size) {
            sum += nums[j]
            count++
            if (count >= 2) {
                if (k == 0 && sum == 0) {
                    return true
                }
                if (k != 0 && sum % k == 0) {
                    return true
                }
            }
        }
    }
    return false
}

fun checkSubarraySum(nums : IntArray, k : Int) : Boolean {
    var sum = 0
    val map = HashMap<Int, Int>()
    map[0] = -1
    for (i in nums.indices) {
        sum += nums[i]
        if (k != 0)
            sum %= k
        if (map.containsKey(sum)) {
            if (i - map[sum]!! > 1)
                return true
        } else {
            map[sum] = i
        }
    }
    return false
}

fun main() {
    println(checkSubarraySum(intArrayOf(23,2,4,6,7), 6))
    println(checkSubarraySum(intArrayOf(0,0), 0))
}