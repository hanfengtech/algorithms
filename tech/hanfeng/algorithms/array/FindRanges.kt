package tech.hanfeng.algorithms.array

// To execute Kotlin code, please define a top level function named main


/*

Given an arbitrarily large array of integers, return a string detailing an ordered range for that array.

Examples:
[0, 1, 2, 3, 8] -> “0-3, 8”
[3, 4, 8] -> “3-4, 8”
[1, 5, 8, 10] -> “1, 5, 8, 10”
[3, 4, 5, 6, 1021, 1022] -> “3-6, 1021-1022”

*/
fun findRange(nums : IntArray) : String {
    var sb = StringBuilder()
    if (nums.isEmpty()) return String()

    var start = 0
    var end = 0
    var value = nums[0]

    for (i in 1 until nums.size){
        if (nums[i] == value + 1) {
            end++
            value++
        } else {
            if (start == end) {
                sb.append("${nums[end]}")
            } else {
                sb.append("${nums[start]}-${nums[end]}")
            }

            if (i < nums.size - 1) {
                sb.append(", ")
            }

            start = i
            end = i
            value = nums[i]
        }
    }

    if (start == end) {
        sb.append(", ${nums[end]}")
    } else {
        sb.append("${nums[start]}-${nums[end]}")
    }

    return sb.toString()
}

fun main(args: Array<String>) {
    println(findRange(intArrayOf(0,1,2,3,8)))
    println(findRange(intArrayOf(3,4,8)))
    println(findRange(intArrayOf(1,5,8,10)))
    println(findRange(intArrayOf(3, 4, 5, 6, 1021, 1022)))
}
