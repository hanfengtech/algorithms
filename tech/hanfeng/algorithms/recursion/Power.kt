package tech.hanfeng.algorithms.recursion

fun pow(n : Int, k : Int) : Int = if (k == 0) 1 else n * pow(n, k - 1)

fun power(n: Int, k : Int) : Int {
    var result = 1
    for (i in 1 .. k) {
        result *= n
    }

    return result
}

fun powbs(x : Double, n : Int) : Double {
    var pow = n
    var b = x
    if ( pow == 0) return 1.toDouble()
    if (pow < 0) {
        pow = -pow
        b = 1 / b
    }

    return if (pow % 2 == 0) powbs(b * b, pow / 2) else b * powbs(b * b, pow / 2)
}

fun main() {
    println(pow(2, 3))
    println(power(2, 3))
    println(powbs(30.0, 25))
}