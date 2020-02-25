package tech.hanfeng.algorithms.array
import kotlin.collections.HashMap

/**
 *
 * Given an array of integers and see if there is any two integers add up to a target value.  Returns the index of the
 * two integers
 *
 * @example
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 *
 * return [0, 1].
 *
 * @time_complexity
 * O(N)
 *
 * @space_comlexity
 * O(N)
 *
 * @difficulty
 * Easy
 */
fun twoSum(nums : IntArray, target: Int) : IntArray {
    val map = HashMap<Int, Int>()

    for ((i, num) in nums.withIndex()) {
        val complement = target - num
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        } else {
            map[num] = i
        }
    }
    throw IllegalArgumentException("No two sum solution")
}


/**
 * @output
 *
 *  [0, 1]
 *  Exception in thread "main" java.lang.IllegalArgumentException: No two sum solution
 *          at tech.hanfeng.algorithms.array.TwoSum.twoSum(TwoSum.java:40)
 *          at tech.hanfeng.algorithms.array.client.TwoSumClient.main(TwoSumClient.java:21)
 */
fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 13).contentToString())
    println(twoSum(intArrayOf(2, 7, 11, 15), 30).contentToString())
}