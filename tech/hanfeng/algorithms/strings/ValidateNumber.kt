package tech.hanfeng.algorithms.strings

fun isNumber(s : String) : Boolean {
    if (s.isEmpty()) return false

    val str = s.trim()
    var isDigitSeen = false
    var isDecimalSeen = false
    var iseSeen = false

    for(i in str.indices) {
        val c = str[i]

        if (c.isDigit()) {
            isDigitSeen = true
        } else if (c == '.') {
            if (isDecimalSeen || iseSeen) return false   // no ducplicate . and no e infront
            isDecimalSeen = true
        } else if (c == 'e') {
            if (i == str.length - 1 || iseSeen || !isDigitSeen) {  // e is not the last ch,
                return false
            }
            iseSeen = true
        } else if (c == '+' || c == '-') {
            if ( (i != 0 && str[i-1] != 'e') || i == str.length - 1) {
                return false
            }
        } else {
            return false
        }
    }

    return isDigitSeen
}

fun main() {
    var num = "123e52"

    /*
    println(isNumber(num))

    num = "123.24e52"
    println(isNumber(num))

    num = "123.24e52e"
    println(isNumber(num))

    num = "1.23.24e52"
    println(isNumber(num))

    num = "-123.24e52"
    println(isNumber(num))

    num = "+123.24e52"
    println(isNumber(num))

    num = "12324e52.24"
    println(isNumber(num))

    num = "123a24e52"
    println(isNumber(num))

    num = ".2324e52"
    println(isNumber(num))
     */

    num = ".1"
    println(isNumber(num))

}