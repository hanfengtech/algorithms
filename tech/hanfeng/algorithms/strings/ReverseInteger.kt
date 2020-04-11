package tech.hanfeng.algorithms.strings

fun reverse(x : Int) : Int {
    val arr = x.toString().toCharArray()

    var i = 0
    if (arr[0] == '-') {
        i = 1
    }

    var j = arr.size - 1

    while (i < j) {
        val tmp = arr[i]
        arr[i++] = arr[j]
        arr[j--] = tmp
    }

    try {
        return String(arr).toInt()
    } catch (e : NumberFormatException) {}

    return 0
}

fun main(){
    var x = 123
    println(reverse(x))

    x = -123
    println(reverse(x))

    x = 120
    println(reverse(x))

    x = -1234567899
    println(reverse(x))
}