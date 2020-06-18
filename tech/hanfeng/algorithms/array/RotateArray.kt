package tech.hanfeng.algorithms.array

fun rotate(nums : IntArray, k : Int) {
    val N = nums.size
    if (N <= 0 || k <= 0) return
    val K = k % N
    revert(nums, 0, N - 1)
    revert(nums, 0, K - 1)
    revert(nums, K, N - 1)
}

fun revert(nums: IntArray, start : Int, end : Int) {
    var i = start
    var j = end

    while (i < j) {
        val num = nums[i]
        nums[i++] = nums[j]
        nums[j--] = num
    }
}

fun rotate2(nums: IntArray, k: Int) {
    var cur = k % nums.size
    while (cur != 0) {
        val temp = nums[0]
        nums[0] = nums[cur]
        nums[cur] = temp
        cur = (cur + k) % nums.size
    }
}

fun main() {
    var nums = intArrayOf(1,2,3,4,5,6,7)
    rotate2(nums, 3)
    println(nums.contentToString())
}