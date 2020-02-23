package tech.hanfeng.algorithms.array

fun removeElement(A : IntArray, num: Int) : Int {
    if (A.isEmpty()) return 0

    var slow = 0
    for (fast in A.indices) {
        if (A[fast] != num) {
            A[slow++] = A[fast]
        }
    }

    return slow
}

fun main() {
    println(removeElement(intArrayOf(3,2,2,4,3), 3))
    println(removeElement(intArrayOf(), 4))
}