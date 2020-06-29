package tech.hanfeng.algorithms.binarysearch

fun findMin(nums: IntArray): Int {
    var lo = 0
    var hi = nums.size - 1
    while (lo < hi) {
        val mid = lo + (hi - lo) / 2

        if (nums[mid] < nums[hi]) {
            hi = mid
        } else {
            lo = mid + 1
        }
    }
    return nums[lo]
}

fun main() {
    println(findMin(intArrayOf(4,5,6,7,0,1,2)))
    println(findMin(intArrayOf(3,4,5,1,2)))
}