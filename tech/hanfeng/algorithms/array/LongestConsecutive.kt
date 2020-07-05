package tech.hanfeng.algorithms.array.util

fun longestConsecutive(nums: IntArray) : Int {
    var res = 0
    var set = nums.toSet()

    for (num in set) {
        var currNum = num
        if (currNum - 1 !in set) {
            var count = 1
            while (currNum + 1 in set) {
                currNum++
                count++
            }
            res = maxOf(res, count)
        }
    }

    return res
}

fun main() {
    println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
}