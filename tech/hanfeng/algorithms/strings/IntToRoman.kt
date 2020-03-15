package tech.hanfeng.algorithms.strings

fun intToRoman(num : Int) : String {
    val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val strs = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    val sb = StringBuilder()
    var remaining = num

    for (i in values.indices) {
        while (remaining >= values[i]) {
            remaining -= values[i]
            sb.append(strs[i])
        }
    }
    return sb.toString()
}

fun main() {
    println(intToRoman(3))
    println(intToRoman(4))
    println(intToRoman(9))
    println(intToRoman(58))
    println(intToRoman(1994))
    println(intToRoman(10994))
}