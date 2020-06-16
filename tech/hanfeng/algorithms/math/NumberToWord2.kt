package tech.hanfeng.algorithms.math

import java.util.*


private val places = HashMap<Int, String>()
private val pre = HashMap<Int, String>()

fun main() {
    places[0] = ""
    places[1] = " thousand "
    places[2] = " million "
    places[3] = " billion "
    pre[1] = "one"
    pre[2] = "two"
    pre[3] = "three"
    pre[4] = "four"
    pre[5] = "five"
    pre[6] = "six"
    pre[7] = "seven"
    pre[8] = "eight"
    pre[9] = "nine"
    pre[10] = "ten"
    pre[11] = "eleven"
    pre[12] = "twelve"
    pre[13] = "thirteen"
    pre[14] = "fourteen"
    pre[15] = "fifteen"
    pre[16] = "sixteen"
    pre[17] = "seventeen"
    pre[18] = "eighteen"
    pre[19] = "nineteen"
    pre[20] = "twenty"
    pre[30] = "thirty"
    pre[40] = "fourty"
    pre[50] = "fifty"
    pre[60] = "sixty"
    pre[70] = "seventy"
    pre[80] = "eighty"
    pre[90] = "ninty"
    println(convertDigitToWord(1238562701))
}

fun convertDigitToWord(digit: Int): String? {
    var digit = digit
    var output = ""
    var i = 1
    while (i <= 5 && digit > 0) {
        var divisor = 1000
        val newNumber = digit % (divisor)
        output = getStringFrom3Digit(newNumber) + places[i - 1] + output
        digit /= 1000
        i++
    }
    return output
}

fun getStringFrom3Digit(digit: Int): String {
    var digit = digit
    var output = ""
    if (digit / 100 > 0) {
        output = pre[digit / 100].toString() + " hundered"
    }
    digit %= 100
    if (pre.containsKey(digit)) {
        output += " " + pre[digit]
    } else {
        if (digit / 10 > 0) {
            output += " " + pre[digit / 10 * 10]
        }
        digit %= 10
        if (digit > 0) {
            output += " " + pre[digit]
        }
    }
    return output
}