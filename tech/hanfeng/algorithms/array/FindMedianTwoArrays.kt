package tech.hanfeng.algorithms.array

fun findMedianTwoArrays(A : IntArray, B : IntArray) : Double {
    val n = A.size
    val m = B.size

    if (m < n) {
        return findMedianTwoArrays(B, A)
    }

    val k = (n  + m + 1) / 2
    var l = 0
    var r = n
    var m1 : Int
    var m2 : Int

    while (l < r) {
        m1 = l + (r - l) / 2
        m2 = k - m1

        if (A[m1] < B[m2 - 1]) {
            l = m1 + 1
        } else {
            r = m1
        }
    }

    m1 = l
    m2 = k - l

    val c1 = Math.max( if (m1 <= 0) Int.MIN_VALUE else A[m1 - 1],
                       if (m2 <= 0) Int.MIN_VALUE else B[m2 - 1]) * 1.0

    if ((n + m) % 2 == 1)
        return c1

    val c2 = Math.min( if (m1 >= n) Int.MAX_VALUE else A[m1],
                       if (m2 >= m) Int.MAX_VALUE else B[m2])

    return (c1 + c2) / 2.0
}

fun main() {
    println(findMedianTwoArrays(intArrayOf(1,3), intArrayOf(2)))
}
