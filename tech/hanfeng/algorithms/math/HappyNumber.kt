package tech.hanfeng.algorithms.math

fun isHappy(n : Int) : Boolean {
    var slow = n
    var fast = n

    do {
        slow = next(slow)
        fast = next(next(fast))
        if (slow == 1 || fast == 1) {
            return true
        }
    } while (slow != fast)
    return false
}

fun next(n : Int) : Int {   // sum of squaring the digits
    var num = n
    var sum = 0
    while (num > 0) {
        val digit = num % 10
        sum += digit * digit
        num /= 10
    }
    return sum
}

fun main() {
    println(isHappy(19))
    println(isHappy(20))
}