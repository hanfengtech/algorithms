package tech.hanfeng.algorithms.array

fun mergeSortedArray(num1 : IntArray, m : Int, num2 : IntArray, n: Int) {

    var i = m - 1
    var j = n - 1
    var k = m + n - 1

    while (i >= 0 && j >= 0) {
        num1[k--] = if (num1[i] > num2[j]) num1[i--] else num2[j--]
    }

    while(j > 0) {
        num1[k--] = num2[j]
    }
}

fun main() {
    var nums = intArrayOf(1,2,3,0,0,0)
    mergeSortedArray(nums, 3, intArrayOf(2,5,6), 3)
    println(nums.contentToString())
}