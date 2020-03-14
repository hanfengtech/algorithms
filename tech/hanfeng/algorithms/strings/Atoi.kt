package tech.hanfeng.algorithms.strings

const val NEGATIVE = -1
const val POSITIVE = 1

fun atoi(str: String) : Int {
    var index = 0
    var sign = POSITIVE
    var total = 0

    // Emtpy string
    if (str.isEmpty()) return 0

    // Remove spaces
    while(index < str.length && str[index] == ' ') {
        index++
    }

    // handle sign
    if (index < str.length && (str[index] == '+' || str[index] == '-')) {
        sign = if (str[index] == '+') POSITIVE else NEGATIVE
        index++
    }

    // Convert number and avoid overflow
    while (index < str.length) {
        val digit = str[index] - '0'
        if (digit < 0 || digit > 9) break

        if (total > Int.MAX_VALUE / 10 || total == Int.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)
            return if (sign == POSITIVE) Int.MAX_VALUE else Int.MIN_VALUE

        total = 10 * total + digit
        index++
    }
    return sign * total
}

fun main() {
    println(atoi("   1234"))
    println(atoi("   -23 5.7"))
    println(atoi("  "))
}