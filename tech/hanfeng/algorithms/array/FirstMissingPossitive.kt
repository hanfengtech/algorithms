package tech.hanfeng.algorithms.array

fun firstMissingPositive2(nums: IntArray): Int {
    val n: Int = nums.size

    var contains = 0
    for (i in 0 until n) {
        if (nums[i] == 1) {
            contains++
            break
        }
    }

    if (contains == 0) return 1  // cannot find 1  return 1

    if (n == 1) return 2         // there is only on number and its value is 1, return next positive value which is 2

    for (i in 0 until n) {
        if (nums[i] <= 0 || nums[i] > n)   // any negative or number greater than n set to 1
            nums[i] = 1
    }

    for (i in 0 until n) {
        val index = Math.abs(nums[i])
        if (index == n)
            nums[0] = -Math.abs(nums[0])   // use the value in index 0 to indicate if n exist or not
        else
            nums[index] = -Math.abs(nums[index])   // negative the abs value of the index
    }

    for (i in 1 until n) {             // if there is a positive value, return the index representing the missing positive
        if (nums[i] > 0) return i
    }

    return if (nums[0] > 0) n else n + 1   // if value in index 0 is positive, return n else n + 1
}


fun firstMissingPositive(nums: IntArray): Int {
    var n = nums.size
    var i = 0
    while (i < n) {
        var num = nums[i]
        var index = num - 1
        if (index in 0 until n && nums[index] != num) {
            nums[i] = nums[index]
            nums[index] = num
        } else {
            i++
        }
    }

    for (i in nums.indices) {
        if (nums[i] != i+1) return i+1
    }

    return n + 1
}

fun main() {
    println(firstMissingPositive(intArrayOf(4,1,2,3)))
    println(firstMissingPositive(intArrayOf(5,3,-2,1)))
    println(firstMissingPositive(intArrayOf(-1, -2)))
    println(firstMissingPositive(intArrayOf(1)))
}