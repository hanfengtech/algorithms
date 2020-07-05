package tech.hanfeng.algorithms.array

fun firstDuplicate(nums : IntArray) : Int {
    for (i in nums.indices) {
        val index = Math.abs(nums[i]) - 1
        if (nums[index] < 0) {
            return nums[i]
        } else {
            nums[index] = -index - 1
        }
    }
    return -1
}

fun main() {
    println(firstDuplicate(intArrayOf(1,2,1,3,4,3,2)))
    println(firstDuplicate(intArrayOf(1,2,3,4,5,6,7)))
    println(firstDuplicate(intArrayOf(1,2,3,3,4,3,2)))
}