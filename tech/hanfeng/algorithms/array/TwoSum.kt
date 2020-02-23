package tech.hanfeng.algorithms.array
import kotlin.collections.HashMap

/**
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

    var i = 0
    for (num in nums) {
        val complement = target - num
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        } else {
            map[num] = i++
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
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
    println(twoSum(intArrayOf(2, 7, 11, 15), 30).contentToString())
}