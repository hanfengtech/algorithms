package tech.hanfeng.algorithms.array

fun majorityElement(num : IntArray) : Int {
    var major = num[0]
    var count = 1

    for (i in 1 until num.size) {
        if (count == 0) {
            major = num[i]
            count++
        } else if (major == num[i]) {
            count++
        } else {
            count--
        }
    }

    return major
}

fun main() {
    println(majorityElement(intArrayOf(3,2,2,2,3)))
    println(majorityElement(intArrayOf(3,3,3,2,2,2,3)))
}