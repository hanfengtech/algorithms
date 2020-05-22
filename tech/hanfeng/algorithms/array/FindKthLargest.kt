package tech.hanfeng.algorithms.array
fun findKthLargest(nums : IntArray, k : Int) : Int {
    var left = 0
    var right = nums.size - 1
    val targetIndex = nums.size - k
    while (left <= right) {
        var pivotIndex = partition(nums, left, right)
        if (pivotIndex == targetIndex)
            return nums[targetIndex]
        else if (pivotIndex > targetIndex)
            right = pivotIndex - 1
        else
            left = pivotIndex + 1
    }
    return -1
}

fun partition(nums: IntArray, low : Int, high : Int) : Int {
    var pivot = nums[high]
    var index = low
    for (i in low until high) {
        if (nums[i] <= pivot) {
            nums.swap(i, index)
            index++
        }
    }
    nums.swap(index, high)
    return index
}

fun IntArray.swap(i : Int, j : Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

fun main() {
    println(findKthLargest(intArrayOf(5,7,2,3,4,1,6), 3))
}