package tech.hanfeng.algorithms.array

fun pivotIndex2(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var l = 0
    var r = nums.size - 1

    var lsum = nums[l]
    var rsum = nums[r]

    while (l <= r) {
        if (lsum == rsum) {
            l++
            r--
            break
        } else if (lsum > rsum) {
            r--
            if (r >= 0)
            rsum += nums[r]
        } else {
            l++
            if (l < r)
            lsum += nums[l]
        }
    }
    if (l > r) return -1
    return if (r - l <= 1) return l else -1
}


fun pivotIndex(nums: IntArray): Int {
    var sum = 0
    var left = 0
    for (i in nums.indices) {
        sum += nums[i]
    }
    for (i in nums.indices) {
        if (left == sum - left - nums[i]) return i
        left += nums[i]
    }
    return -1
}

fun main() {
    println(pivotIndex(intArrayOf(-1,-1,-1,-1,-1,0)))
    println(pivotIndex(intArrayOf(1,2,3)))
    println(pivotIndex(intArrayOf(1,7,3,6,5,6)))
}