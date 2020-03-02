package tech.hanfeng.algorithms.recursion

fun pow(n : Int, k : Int) : Int = if (k == 0) 1 else n * pow(n, k - 1)

fun power(n: Int, k : Int) : Int {
    var result = 1
    for (i in 1 .. k) {
        result *= n
    }

    return result
}

fun main() {
    println(pow(2, 3))
    println(power(2, 3))
}