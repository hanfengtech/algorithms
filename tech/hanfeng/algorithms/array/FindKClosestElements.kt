package tech.hanfeng.algorithms.array

import java.util.*

fun findClosestElementsBS(arr: IntArray, k : Int, x : Int) : List<Int> {
    val n: Int = arr.size
    return if (x <= arr[0]) {
        arr.copyOfRange(0, k).toList()
    } else if (arr[n - 1] <= x) {
        arr.copyOfRange(n - k, n).toList()
    } else {
        var index: Int = Arrays.binarySearch(arr, x)
        if (index < 0) index = -index - 1
        var low = Math.max(0, index - k - 1)
        var high = Math.min(arr.size - 1, index + k - 1)
        while (high - low > k - 1) {
            val lowDiff = x - arr[low]
            val highDiff = arr[low] - x
            if (low < 0 || lowDiff <= highDiff) high--
            else if (high > arr.size - 1 || lowDiff > highDiff) low++
            else println("unhandled case: $low $high")
        }
        arr.copyOfRange(low, high + 1).toList()
    }
}

fun main() {
    println(findClosestElementsBS(intArrayOf(1,2,3,4,7), 4, 3))
    println(findClosestElementsBS(intArrayOf(1,2,3,4,5,6,7,8,9,10), 4, 20))
    println(findClosestElementsBS(intArrayOf(1,1,1,10,10,10), 4, 9))
}