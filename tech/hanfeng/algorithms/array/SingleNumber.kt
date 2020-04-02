package tech.hanfeng.algorithms.array

fun singleNumber(nums: IntArray) : Int {
    if (nums.size == 1) {
        return nums[0]
    }

    var result = 0

    nums.forEach{
        result = result xor it
    }

    return result
}

fun singleNumberOneLine(nums: IntArray) : Int = nums.reduce { a, b -> a xor b }

fun main() {
    println(singleNumber(intArrayOf(2,2,1)))
    println(singleNumber(intArrayOf(4,1,2,1,2)))
    println(singleNumber(intArrayOf(6,2,2,6,7)))

    println(singleNumberOneLine(intArrayOf(2,2,1)))
    println(singleNumberOneLine(intArrayOf(4,1,2,1,2)))
    println(singleNumberOneLine(intArrayOf(6,2,2,6,7)))
}