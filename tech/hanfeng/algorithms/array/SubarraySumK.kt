package tech.hanfeng.algorithms.array

fun subarraySum(nums: IntArray, k: Int): Int {
    if (nums.isEmpty()) return 0
    var count = 0
    var sum = 0
    val map = HashMap<Int, Int>()
    map[0] = 1

    nums.forEach {
        sum += it
        if (map.contains(sum - k)) {
            count += map[sum - k]!!
        }
        map[sum] = map.getOrDefault(sum, 0) + 1
    }
    return count
}

fun main() {
    println(subarraySum(intArrayOf(1,1,1), 2))
}

