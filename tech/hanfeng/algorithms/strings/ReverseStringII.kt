package tech.hanfeng.algorithms.strings

fun reverseStr(s: String, k: Int): String {

    fun swap(a : CharArray, i : Int, j : Int) {
        val tmp = a[i]
        a[i] =a[j]
        a[j] = tmp
    }

    fun reverse(a : CharArray, begin: Int, end:Int) {
        var i = begin
        var j = end

        while(i < j) {
            swap(a, i++, j--)
        }
    }

    var i = 0
    val len = s.length

    val a = s.toCharArray()

    while (i < len) {
        if (i + k < len) {
            reverse(a, i, i + k - 1)
        } else {
            reverse(a, i, len - 1)
        }
        i += 2 * k
    }

    return String(a)
}

fun main() {
    println(reverseStr("abcdefg", 2))
}



