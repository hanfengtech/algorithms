package tech.hanfeng.algorithms.math

fun pow(ix: Double, n: Int): Double {
    var N = n.toLong()
    var x = ix
    if (N < 0) {
        x = 1 /x
        N = -N
    }

    var ans = 1.0
    var product = x

    var i = N

    while (i > 0) {
        if ((i % 2) == 1L) {
            ans *= product
        }
        product *= product
        i /= 2
    }
    return ans
}

fun main() {
    println(pow(2.0,2))
    println(pow(2.0,10))
    println(pow(4.0,9))
}