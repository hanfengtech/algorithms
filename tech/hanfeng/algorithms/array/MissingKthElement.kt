package tech.hanfeng.algorithms.array

fun missingElement(nums: IntArray, k: Int): Int {
    var kth = k

    var cur = nums[0]
    var i = 1

    while (i < nums.size) {
        cur++
        if (cur != nums[i]) {  // missing
            kth--
            if (kth == 0) return cur
        } else {
            i++
        }
    }

    while (kth-- > 0) cur++

    return cur
}

fun missingElementBS(nums: IntArray, k : Int) : Int {
    var l = 0
    var h = nums.size
    while (l < h) {
        val m = l + (h - l) / 2
        if (nums[m] - m - k >= nums[0]) {
            h = m
        } else {
            l = m + 1
        }
    }

    return nums[0] + l + k - 1
}

fun main() {
    println(missingElementBS(intArrayOf(4,7,9,10), 3))
    println(missingElementBS(intArrayOf(1,2,3), 3))
}