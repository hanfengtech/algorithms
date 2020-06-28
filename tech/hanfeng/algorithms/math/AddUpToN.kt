package tech.hanfeng.algorithms.math

fun addUpTo(n : Int) : Int {
    var sum = 0
    for (i in 1 .. n) {
        sum += i
    }
    return sum
}

fun main() {
    println(addUpTo(2))   // 1 + 2 = 3
    println(addUpTo(5))   // 1 + 2 + 3 + 4 + 5 = 15
    println(addUpTo(10))
    println(addUpTo(100))
    println(addUpTo(200))
    println(addUpTo(10000))
}