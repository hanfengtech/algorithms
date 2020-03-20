package tech.hanfeng.algorithms.strings

fun reverseString(s: CharArray): Unit {
    var i = 0
    var j = s.size - 1

    while (i < j) {
        swap(s, i++, j--)
    }
}

fun swap(a : CharArray, i : Int, j : Int) {
    val tmp = a[i]
    a[i] =a[j]
    a[j] = tmp
}

fun main() {
    val arr = charArrayOf('c', 'a', 't')
    reverseString(arr)
    println(arr.contentToString())
}