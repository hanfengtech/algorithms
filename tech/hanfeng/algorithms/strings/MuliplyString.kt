package tech.hanfeng.algorithms.strings

import java.lang.StringBuilder

fun multiply(num1 : String, num2 : String) : String {
    val m = num1.length
    val n = num2.length

    val pos = IntArray(m + n) { 0 }

    for (i in m - 1 downTo 0) {
        for (j in n - 1 downTo 0) {
            val mul = (num1[i] - '0') * (num2[j] - '0')
            val p1 = i + j
            val p2 = i + j + 1
            val sum = mul + pos[p2]

            pos[p1] += sum / 10
            pos[p2] = sum % 10
        }
    }

    val sb = StringBuilder()

    for (p in pos) {
        if (!(sb.isEmpty() && p == 0))
            sb.append(p)
    }

    return if (sb.isNotEmpty()) sb.toString() else "0"
}

fun main() {
    println(multiply("789", "359"))
}