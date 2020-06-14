package tech.hanfeng.algorithms.math

fun isStrobogrammatic(num: String) : Boolean {
    var sb = StringBuilder()
    for(i in num.length - 1 downTo 0) {
        var c = num[i]
        c = when(c) {
            '6' -> '9'
            '9' -> '6'
            '2','3','4','5','7' -> '!'
            else -> c
        }

        if (c == '!') return false

        sb.append(c)
    }

    return num == sb.toString()
}

fun main() {
    println(isStrobogrammatic("69"))
}