package tech.hanfeng.algorithms.array

fun findDuplicatedInArray(nums: IntArray) : List<Int> {
    var ans = HashSet<Int>()
    for (num in nums) {
        val index = Math.abs(num) - 1
        if (nums[index] < 0) {
            ans.add(Math.abs(num))
        } else {
            nums[index] *= -1
        }
    }
    return ans.toList()
}

fun main() {
    println(findDuplicatedInArray(intArrayOf(4,3,2,7,8,2,3,1)))
    println(findDuplicatedInArray(intArrayOf(4,3,2,3,3,2,3,1)))
}