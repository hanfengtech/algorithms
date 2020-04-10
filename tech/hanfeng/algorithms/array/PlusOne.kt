package tech.hanfeng.algorithms.array

import java.util.*

fun plusOne(digits : IntArray): IntArray {
    var carry = 0
    var n = digits.size - 1

    for(i in n downTo 0) {
        var sum = digits[i]
        sum += carry

        if (i == n) {
            sum += 1
        }

        if (sum == 10) {
            carry = 1
            sum = 0
        } else {
            carry = 0
        }

        digits[i] = sum

        if (carry == 0) {
            return digits
        }
    }

    if (carry == 1) {
        var result = IntArray(digits.size + 1)
        result[0] = 1
        Arrays.copyOfRange(digits, 1, result.size)
        return result
    }

    return digits
}

fun main() {
    println(plusOne(intArrayOf(1,2,3)).contentToString())
    println(plusOne(intArrayOf(1,2,9)).contentToString())
    println(plusOne(intArrayOf(9,9,9)).contentToString())
}