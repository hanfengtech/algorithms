package tech.hanfeng.algorithms.array

/*
input:  arr = [0, 1, 2, 3]

output: 4


input:  arr = [2, 4, 1, 6]
               2, 4  -1 6
 */

fun getDiffNum(arr : IntArray) : Int {
    for (i in arr.indices) {
        if (i != arr[i]) {
            val targetIndex = Math.abs(arr[i])
            if (targetIndex < arr.size) {
                arr[targetIndex] = -arr[targetIndex]
            }
        }
    }

    var i = 0

    while (i < arr.size) {
        if (i != arr[i] && arr[i] > 0)
            return i
        i++
    }
    return i
}

fun main() {
    println(getDiffNum(intArrayOf(0,1,2,3)))
    println(getDiffNum(intArrayOf(2,4,1,6)))
    println(getDiffNum(intArrayOf(0, 5, 4, 1, 3, 6, 2)))
}
