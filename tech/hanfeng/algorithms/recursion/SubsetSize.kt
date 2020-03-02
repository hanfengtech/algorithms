package tech.hanfeng.algorithms.recursion

fun subsetSize(n : Int) : Int = if (n == 0) 1 else 2 * subsetSize(n - 1)

fun subsetSizeIt(n : Int) : Int {
    var result = 1
    for (i in 1..n) {
        result *= 2
    }
    return result
}

fun main() {
    println(subsetSize(4))
    println(subsetSizeIt(4))
}