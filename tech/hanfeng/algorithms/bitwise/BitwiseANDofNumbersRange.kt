package tech.hanfeng.algorithms.bitwise

fun rangeBitwiseAnd(m: Int, n: Int): Int {
    var left = m
    var right = n
    var count = 0
    while (left != right) {
        left = left shr 1
        right = right shr 1
        count++
    }
    return left shl count
}

fun main() {
    println(rangeBitwiseAnd(5, 7))
    println(rangeBitwiseAnd(0, 1))
}