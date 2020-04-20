package tech.hanfeng.algorithms.search

fun search(nums: IntArray, target : Int) : Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        var mid = left + (right - left) / 2
        if (target == nums[mid]) {
            return mid
        }

        if (nums[mid] < nums[right]) {   //  last part is ascending order
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        } else {  // first part is ascending order
            if (target < nums[mid] && target >= nums[left]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
    }

    return -1
}

fun main() {
    println(search(intArrayOf(4,5,6,7,0,1,2), 0))
    println(search(intArrayOf(4,5,6,7,0,1,2), 3))
    println(search(intArrayOf(5,1,3), 3))
    println(search(intArrayOf(1), 1))
    println(search(intArrayOf(), 1))
    println(search(intArrayOf(3,1), 1))
}