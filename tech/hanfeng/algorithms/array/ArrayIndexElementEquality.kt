package tech.hanfeng.algorithms.array

fun indexEqualsValueSearch(arr: IntArray?): Int {
    if (arr == null) return -1
    var i = 0
    var j = arr.size
    var res = -1
    while (i < j) {
        val m = i + (j - i) / 2
        if (arr[m] == m) {
            res = m
            j = m
        } else if (arr[m] < m) {
            i = m + 1
        } else {
            j = m
        }
    }
    return res
}

fun main() {
    println(indexEqualsValueSearch(intArrayOf(-8,0,2,5)))
    println(indexEqualsValueSearch(intArrayOf(-1,0,3,6)))
}