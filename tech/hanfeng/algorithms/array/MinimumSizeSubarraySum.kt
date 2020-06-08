package tech.hanfeng.algorithms.array

fun minSubArrayLen(nums : IntArray, s : Int) : Int {
    if (nums.isEmpty()) return 0

                        // s = 7
                        // nums = [2,3,1,2,4,3]
    var l = 0           // 0, 1, 2, 3, 4
    var r = 0           // 0, 1, 2, 3, 4, 5, 6
    var minLen = Int.MAX_VALUE      // MAX_VALUE, 3, 2
    var sum = 0         // 0, 2, 5, 6, 8, 6, 10, 7, 6, 9, 7

    while (r < nums.size) {
        sum += nums[r++]
        if (sum == s) {
            val curMinLen = r - l
            minLen = Math.min(minLen, curMinLen)
        } else if (sum > s) {
            while (sum > s) {
                sum -= nums[l++]
                if (sum == s) {
                    val curMinLen = r - l
                    minLen = Math.min(minLen, curMinLen)
                }
            }
        }
    }
    return if (minLen == Int.MAX_VALUE) 0 else minLen
}

fun main() {
    println(minSubArrayLen(intArrayOf(2,3,1,2,4,3), 7))
    println(minSubArrayLen(intArrayOf(2,3,1,2,4,3), 100))
}