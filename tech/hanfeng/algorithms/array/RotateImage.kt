package tech.hanfeng.algorithms.array

import tech.hanfeng.algorithms.array.util.printMatrix

fun rotateImage(matrix : Array<IntArray>) {
    if (matrix.isEmpty()) return

    val n = matrix.size

    // transpose
    for (i in 0 until n) {
        for (j in i until n) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    }

    // reverse
    for (i in 0 until n) {
        reverse(matrix[i])
    }
}

fun reverse(arr : IntArray) {
    var i = 0
    var j = arr.size - 1

    while (i < j) {
        val tmp = arr[i]
        arr[i++] = arr[j]
        arr[j--] = tmp
    }
}

fun main() {
    var matrix = arrayOf(intArrayOf(1,2,3),
                    intArrayOf(4,5,6),
                    intArrayOf(7,8,9))

    rotateImage(matrix)

    printMatrix(matrix)


    matrix = arrayOf(
            intArrayOf(5,  1, 9, 11),
            intArrayOf(2,  4, 8, 10),
            intArrayOf(13, 3, 6,  7),
            intArrayOf(15,14,12, 16))

    rotateImage(matrix)

    printMatrix(matrix)
}

