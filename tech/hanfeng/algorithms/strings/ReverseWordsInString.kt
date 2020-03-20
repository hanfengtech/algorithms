package tech.hanfeng.algorithms.strings

fun reverseWords(s : String) : String {

    var arr = s.toCharArray()

    val str = cleanSpaces(arr)

    arr = str.reversed().toCharArray()

    reverseWord(arr)

    return String(arr)
}

fun reverseWord(a : CharArray) {
    val n = a.size

    var i = 0
    var j = 0

    while (i < n) {
        while (j < n && a[j] != ' ') j++
        reverse(a, i, j - 1)
        j++
        i = j
    }
}

fun reverse(a : CharArray, begin : Int, end : Int) {
    var i = begin
    var j = end

    while (i < j) {
        val tmp = a[i]
        a[i++] = a[j]
        a[j--] = tmp
    }
}

fun cleanSpaces(a : CharArray) : String {
    var i = 0
    var j = 0
    val n = a.size

    while (j < n) {
        while (j < n && a[j] == ' ') j++
        while (j < n && a[j] != ' ') a[i++] = a[j++]
        while (j < n && a[j] == ' ') j++
        if (j < n) a[i++] = ' '
    }

    return String(a).substring(0, i)
}


fun main() {
    println(reverseWords("     the sky is     blue    "))
}