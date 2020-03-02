package tech.hanfeng.algorithms.recursion

fun fact(n: Int) : Int = if (n == 0) 1 else n * fact(n - 1)

fun factorial(n: Int) : Int {
    var result = 1
    for(i in 2..n) {
        result *= i
    }

    return result
}

fun main() {
    println(fact(3))
    println(factorial(3))
    println(factorial(6))
}