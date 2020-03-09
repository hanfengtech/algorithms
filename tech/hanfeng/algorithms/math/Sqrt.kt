package tech.hanfeng.algorithms.math

fun sqrt(x: Int): Int {
    var lo = 0L
    var hi = x.toLong()
    while (hi >= lo) {
        var mid = lo + (hi - lo) / 2   // .shr(2)
        if (x < mid * mid) {
            hi = mid - 1
        } else{
            lo = mid + 1
        }
    }

    return hi.toInt()
}

fun main() {
    println(sqrt(4))
    println(sqrt(2147395599))
}