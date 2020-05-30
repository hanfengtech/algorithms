package tech.hanfeng.algorithms.array

fun subarraySum(nums: IntArray, k: Int): Int {
    if (nums.isEmpty()) return 0
    var count = 0
    var sum = 0
    val map = HashMap<Int, Int>()
    map[0] = 1

    nums.forEach {
        sum += it
        val complement = sum - k
        if (map.contains(complement)) {
            count += map[complement]!!
        }
        map[sum] = map.getOrDefault(sum, 0) + 1
    }
    return count
}

fun main() {
    println(subarraySum(intArrayOf(1,2,3,-1,-1,-1,1), 3))
    println(subarraySum(intArrayOf(1,1,1), 2))
}

