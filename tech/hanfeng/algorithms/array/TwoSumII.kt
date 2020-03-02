package tech.hanfeng.algorithms.array

fun twoSumII(nums : IntArray, target : Int) : IntArray {
    var i = 0
    var j = nums.size - 1

    while (i < j) {
        var sum = nums[i] + nums[j]
        if (sum == target) {
            return intArrayOf(i + 1, j + 1)
        } else if (sum > target) {
            j--
        } else {
            i++
        }
    }

    return intArrayOf()
}

fun main() {
    print(twoSumII(intArrayOf(2,7,11,15), 9).contentToString())
    println(twoSumII(intArrayOf(5,25,75), 100).contentToString())
    println(twoSumII(intArrayOf(2,3,4), 6).contentToString())
    println(twoSumII(intArrayOf(3,24,50,79,88,150,345), 200).contentToString())
    println(twoSumII(intArrayOf(0,0), 0).contentToString())
}