package tech.hanfeng.algorithms.array

import tech.hanfeng.algorithms.array.util.printMatrix

fun rotateImage(matrix : Array<IntArray>) {
    if (matrix.isEmpty()) return
    transpose(matrix)

    for (i in matrix.indices) {
        reverse(matrix[i])
    }
}

fun transpose(M : Array<IntArray>) {
    for (i in M.indices) {
        for (j in i until M.size) {
            val tmp = M[i][j]
            M[i][j] = M[j][i]
            M[j][i] = tmp
        }
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

fun rotateImageCounterClockwise(matrix : Array<IntArray>) {
    if (matrix.isEmpty()) return

    transpose(matrix)
    for (i in matrix.indices) {
        reverse(matrix, i)
    }
}

fun reverse(M : Array<IntArray>, col : Int) {
    var i = 0
    var j = M.size - 1

    while (i < j) {
        val tmp = M[i][col]
        M[i++][col] = M[j][col]
        M[j--][col] = tmp
    }
}

fun main() {
    var matrix = arrayOf(intArrayOf(1,2,3),
                         intArrayOf(4,5,6),
                         intArrayOf(7,8,9))

    rotateImage(matrix)

    printMatrix(matrix)


    println("Rotate image back to original")
    rotateImageCounterClockwise(matrix)

    printMatrix(matrix)


    println()
    matrix = arrayOf(
            intArrayOf(5,  1, 9, 11),
            intArrayOf(2,  4, 8, 10),
            intArrayOf(13, 3, 6,  7),
            intArrayOf(15,14,12, 16))

    rotateImage(matrix)

    printMatrix(matrix)

    println("Rotate image back to original")
    rotateImageCounterClockwise(matrix)

    printMatrix(matrix)
}

