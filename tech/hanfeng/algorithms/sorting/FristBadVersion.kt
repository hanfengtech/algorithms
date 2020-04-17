package tech.hanfeng.algorithms.sorting

fun isBadVersion(ver : Int) : Boolean {
    return when(ver) {
        in 1 .. 3 -> {
            false
        }
        in 4 .. 5 -> {
            true
        }
        else -> {
            true
        }
    }
}

fun firstBadVersion(n: Int) : Int {
    var left = 1
    var right = n
    while (left < right) {
        val mid = left + (right - left) / 2
        if (isBadVersion(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

fun main() {
    println(firstBadVersion(5))
}