package tech.hanfeng.algorithms.array

fun plusOne(digits : IntArray): IntArray {
    var n = digits.size
    for(i in n - 1 downTo 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0
    }

    var result = IntArray(n + 1) { 0 }
    result[0] = 1
    return result
}

fun main() {
    println(plusOne(intArrayOf(1,2,3)).contentToString())
    println(plusOne(intArrayOf(1,2,9)).contentToString())
    println(plusOne(intArrayOf(9,9,9)).contentToString())
}