package tech.hanfeng.algorithms.array

fun containsDuplicate(nums: IntArray): Boolean {
    var set = HashSet<Int>()
    nums.forEach{
        if (set.contains(it)) {
            return true
        }
        set.add(it)
    }
    return false
}

fun main() {
    println(containsDuplicate(intArrayOf(1,2,3,4,1)))
    println(containsDuplicate(intArrayOf(1,2,3,4)))
}
