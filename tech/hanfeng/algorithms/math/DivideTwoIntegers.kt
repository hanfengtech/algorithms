package tech.hanfeng.algorithms.math


val HALF_INT_MIN = -1073741824

fun divide(adividend: Int, adivisor: Int): Int {
    var dividend = adividend
    var divisor = adivisor
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
        return Int.MAX_VALUE
    }

    var negatives = 2
    if (dividend > 0) {
        negatives--
        dividend = -dividend
    }
    if (divisor > 0) {
        negatives--
        divisor = -divisor
    }

    var quotient = 0

    while(divisor >= dividend) {
        var powerOfTwo = -1
        var value = divisor

        while(value >= HALF_INT_MIN && value + value >= dividend) {
            value += value
            powerOfTwo += powerOfTwo
        }

        quotient += powerOfTwo

        dividend -= value
    }

    if (negatives != 1) {
        return -quotient
    }

    return quotient
}

fun main() {
    println(divide(15,-5))
}
