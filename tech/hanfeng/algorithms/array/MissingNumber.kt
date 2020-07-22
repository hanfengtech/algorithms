package tech.hanfeng.algorithms.array

fun missingNumberMath(nums : IntArray) : Int {
    val n = nums.size
    var sum = n * (n + 1) / 2
    var asum = 0
    for (i in nums.indices) {
        asum += nums[i]
    }
    return sum - asum
}

fun missingNumber(nums : IntArray) : Int {
    var missingNumber = nums.size
    nums.forEachIndexed { index, num ->
        missingNumber = missingNumber xor index xor num
    }
    return missingNumber
}

fun main() {
    println(missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)))
    println(missingNumber(intArrayOf(0)))
    println(missingNumber(intArrayOf(0,1)))
    println(missingNumber(intArrayOf(1,0)))
}