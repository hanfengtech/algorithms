package tech.hanfeng.algorithms.array


fun compress(chars: CharArray): Int {
    var cur = 0
    var i = 0

    while (i < chars.size) {
        var key = chars[i]
        var count = 0
        while(i < chars.size && chars[i] == key) {
            count++
            i++
        }

        chars[cur++] = key

        if (count > 1) {
            count.toString().forEach{
                chars[cur++] = it
            }
        }
    }

    return cur
}

fun main() {
    println(compress(charArrayOf('a','a','b','b','c','c','c')))
}