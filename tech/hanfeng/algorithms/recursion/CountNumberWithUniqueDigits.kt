package tech.hanfeng.algorithms.recursion

fun countNumberWithUniqueDigits(n : Int) : Int {
    if (n == 0)
        return 1

    var digits = 9
    var remainingDigits = 9
    var count = n
    var result = 10

    while(count > 1 && remainingDigits > 0) {
        digits *= remainingDigits--
        result += digits
        count--
    }

    return result
}

fun main() {
    println(countNumberWithUniqueDigits(0))
    println(countNumberWithUniqueDigits(1))
    println(countNumberWithUniqueDigits(2))
    println(countNumberWithUniqueDigits(3))
    println(countNumberWithUniqueDigits(10))
}