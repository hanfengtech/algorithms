package tech.hanfeng.algorithms.recursion

// O(1.4 ^ n)
fun fib(n : Int) : Int = if (n == 0 || n == 1) n else fib(n - 1) + fib(n - 2)

// O(N)
fun fibonacci(n : Int) : Int {
    if (n == 0 || n == 1) return n
    var result = 1
    var preResult = 0
    var tmp : Int

    for (i in 2 .. n) {
        tmp = result
        result += preResult
        preResult = tmp
    }

    return result
}

fun main() {
    println(fib(5))
    println(fibonacci(5))
}