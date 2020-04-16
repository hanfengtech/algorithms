package tech.hanfeng.algorithms.array

fun productArrayExceptSelf(nums: IntArray) : IntArray {
    val n = nums.size
    val leftProducts = IntArray(n)
    val rightProducts = IntArray(n)
    val outProducts = IntArray(n)

    leftProducts[0] = 1
    for (i in 1 until n) {
        leftProducts[i] = leftProducts[i-1] * nums[i-1]
    }

    rightProducts[n-1] = 1
    for (i in n - 2 downTo 0) {
        rightProducts[i] = rightProducts[i+1] * nums[i+1]
    }

    for (i in nums.indices) {
        outProducts[i] = leftProducts[i] * rightProducts[i]
    }

    return outProducts
}

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val outProducts = IntArray(n)
    outProducts[0] = 1
    for (i in 1 until n) {
        outProducts[i] = outProducts[i - 1] * nums[i - 1]
    }

    var p = 1
    for (i in n - 1 downTo 0) {
        outProducts[i] *=  p
        p *= nums[i]
    }

    return outProducts
}

fun main() {
    println(productArrayExceptSelf(intArrayOf(1,2,3,4)).contentToString())
    println(productExceptSelf(intArrayOf(1,2,3,4)).contentToString())
}