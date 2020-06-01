package tech.hanfeng.algorithms.array

fun maximumSwap(num : Int) : Int {
    val A = num.toString().toCharArray()
    val last = IntArray(10)
    for (i in A.indices) {   // store the last index of the digits
        last[A[i] - '0'] = i
    }

    for (i in A.indices) {
        var index = A[i] - '0'

        for (j in 9 downTo A[i] - '0') {
            if (last[j] > i  && A[i] != A[last[j]]) {
                swap(A, i, last[j])
                return Integer.valueOf(String(A))
            }
        }
    }

    return num
}

fun main() {
    println(maximumSwap(2359))
    println(maximumSwap(98368))
}