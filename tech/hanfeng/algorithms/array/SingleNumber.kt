package tech.hanfeng.algorithms.array

fun singleNumber(nums: IntArray) : Int {
    var result = 0

    for(num in nums) {
        result = result.xor(num)
    }

    return result
}

fun main() {
    println(singleNumber(intArrayOf(2,2,1)))
    println(singleNumber(intArrayOf(4,1,2,1,2)))
    println(singleNumber(intArrayOf(6,2,2,6,7)))
}