package tech.hanfeng.algorithms.array

/**
 * Remove duplicates in a sorted array in place and return the new array length.
 *
 * T(O) = O(N)
 *
 * S(O) = O(1)
 *
 * Difficulty: Easy
 *
 * @input [1,1,2]
 */
fun removeDuplicates(nums : IntArray) : Int {
    if (nums.isEmpty()) return 0

    var i = 0
    for (j in 1 until nums.size) {
        if (nums[i] != nums[j]) {
            nums[++i] = nums[j]
        }
    }

    return ++i
}

/**
 * @output
 *
 * 2
 * [1, 2, 2]
 */
fun main() {
    var nums = intArrayOf(1,1,2)
    println(removeDuplicates(nums))
    println(nums.contentToString())
}