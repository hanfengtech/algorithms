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

fun indexEVS(arr: IntArray?) : Int {
    if (arr == null || arr.isEmpty()) return -1

    var l = 0
    var r = arr.size
    var res = -1

    while (l < r) {
        val m = l + (r - l) / 2

        if (arr[m] == m) {
            res = m
            r = m
        } else if (arr[m] < m) {
            l = m + 1
        } else {
            r = m
        }
    }
    return res
}

fun main() {
    println(indexEqualsValueSearch(intArrayOf(-8,0,2,5)))
    println(indexEqualsValueSearch(intArrayOf(-1,0,3,6)))

    println(indexEVS(intArrayOf(-8,0,2,5)))
    println(indexEVS(intArrayOf(-1,0,3,6)))
}