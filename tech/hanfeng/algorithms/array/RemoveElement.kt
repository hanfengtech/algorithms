package tech.hanfeng.algorithms.array

/**
 *
 * Given an array of integers. Remove all that matches the target.  Returns the new size of the array.
 *
 * @example
 * Given nums = [3, 2, 2, 4, 3], target = 3,
 *
 * return 3
 *
 * @time_complexity
 * O(N)
 *
 * @space_comlexity
 * O(1)
 *
 * @difficulty
 * Easy
 *
 * @type
 * Two pointers
 */

fun removeElement(A : IntArray, num: Int) : Int {
    if (A.isEmpty()) return 0

    var i = 0
    for (j in A.indices) {
        if (A[j] != num) {
            A[i++] = A[j]
        }
    }

    return i
}

/**
 * @output
 *
 * 3
 * [2, 2, 4, 4, 3]
 * 0
 *
 */
fun main() {
    val nums = intArrayOf(3,2,2,4,3)
    println(removeElement(nums, 3))
    println(nums.contentToString())
    println(removeElement(intArrayOf(), 4))
}