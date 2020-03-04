package tech.hanfeng.algorithms.recursion

// O(n)
fun additiveSeq(n : Int, b0 : Int, b1 : Int) : Int = if (n == 0) b0 else additiveSeq(n - 1, b1, b0 + b1)

fun main() {
    println(additiveSeq(5, 0, 1))
    println(fibonacci(5))
}

