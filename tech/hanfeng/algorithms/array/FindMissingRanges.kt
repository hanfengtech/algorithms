package tech.hanfeng.algorithms.array

fun findMissingRanges(nums : IntArray, lower : Int, upper : Int) : List<String> {
    var result = ArrayList<String>()
    var start = lower

    if (lower == Int.MAX_VALUE) return result

    for (i in nums.indices) {

        if (nums[i] > upper) break

        if (i < nums.size - 1 && nums[i] == nums[i+1]) { // skipping duplicates
            continue
        }

        if (nums[i] == start) {
            start++
        } else {
            result.add(getRange(start, nums[i] - 1))
            if (nums[i] == Int.MAX_VALUE) {
                return result
            }
            start = nums[i] + 1
        }
    }

    if (start <= upper) {
        result.add(getRange(start, upper))
    }

    return result
}

fun getRange(l : Int, h : Int) : String {
    return if (l == h) l.toString() else "$l->$h"
}

fun main() {
    println(findMissingRanges(intArrayOf(0,1,3,50,75,105), 0, 99))
}