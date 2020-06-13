package tech.hanfeng.algorithms.array

fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
    var result = ArrayList<Int>()

    var i = 0
    var j = 0
    var k = 0

    while (i < arr1.size && j < arr2.size && k < arr3.size) {
        if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
            result.add(arr1[i])
            i++
            j++
            k++
        } else {
            var max = Math.max(arr1[i], Math.max(arr2[j], arr3[k]))
            if (arr1[i] != max) i++
            if (arr2[j] != max) j++
            if (arr3[k] != max) k++
        }
    }

    return result
}

fun main() {
    println(arraysIntersection(intArrayOf(1,2,3,4,5), intArrayOf(1,2,5,7,9), intArrayOf(1,3,4,5,8)).joinToString())
}