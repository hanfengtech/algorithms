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

fun reverseString(s : String) : String {
    val arr = s.toCharArray()

    reverseString(arr)

    return String(arr)
}

fun String.reverse() : String {
    var str = this.toCharArray()
    var i = 0
    var j = this.length - 1
    while (i < j) {
        val tmp = str[i]
        str[i++] = str[j]
        str[j--] = tmp
    }
    return String(str)
}

fun main() {
    val arr = charArrayOf('c', 'a', 't')
    reverseString(arr)
    println(arr.contentToString())

    println(reverseString("hello"))

    println("Good morning!".reverse())
}