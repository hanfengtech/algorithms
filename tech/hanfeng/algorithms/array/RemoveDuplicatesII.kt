package tech.hanfeng.algorithms.array

fun removeDuplicatesII(nums :  IntArray) : Int {
    var i = 0
    for (n in nums) {
        if (i < 2 || n > nums[i-2])
            nums[i++] = n
    }
    return i
}

fun main() {
    val arr = intArrayOf(1,1,1,2,2,3)
    println(removeDuplicatesII(arr))
    println(arr.contentToString())
}