package tech.hanfeng.algorithms.array

fun findMissingRanges(nums : IntArray, lower : Int, upper : Int) : List<String> {
    val res = ArrayList<String>()
    if (nums.isEmpty())
        return res.apply { this.add(fromRange(lower, upper))}

    if (nums[0] > lower)
        res.add(fromRange(lower, nums[0] - 1))

    for (i in 0 until nums.lastIndex)
        if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1)
            res.add(fromRange(nums[i] + 1, nums[i + 1] - 1))

    if (nums[nums.lastIndex] < upper)
        res.add(fromRange(nums[nums.lastIndex] + 1, upper))

    return res
}

fun findMissingRanges2(nums : IntArray, lower : Int, upper : Int) : List<String> {
    var result = ArrayList<String>()
    var start = lower

    if (lower == Int.MAX_VALUE) return result

    for (i in 0 until nums.lastIndex) {

        if (nums[i] > upper) break

        if (nums[i] == nums[i+1]) { // skipping duplicates
            continue
        }

        if (nums[i] == start) {
            start++
        } else {
            result.add(fromRange(start, nums[i] - 1))
            if (nums[i] == Int.MAX_VALUE) {
                return result
            }
            start = nums[i] + 1
        }
    }

    if (start <= upper) {
        result.add(fromRange(start, upper))
    }

    return result
}

fun fromRange(l : Int, h : Int) : String = if (l == h) l.toString() else "$l->$h"

fun main() {
    println(findMissingRanges(intArrayOf(0,1,1,3,3,50,75,105), 0, 99))
    println(findMissingRanges2(intArrayOf(0,1,1,3,3,50,75,105), 0, 99))
}