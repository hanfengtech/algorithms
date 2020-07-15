package tech.hanfeng.algorithms.matrix

import java.util.*

fun spiralOrder(matrix : Array<IntArray>): List<Int> {
    var res = ArrayList<Int>()
    if (matrix.isEmpty()) return res

    var rowStart = 0
    var rowEnd = matrix.size - 1
    var colStart = 0
    var colEnd = matrix[0].size - 1

    while(rowStart <= rowEnd && colStart <= colEnd) {
        for (col in colStart .. colEnd) res.add(matrix[rowStart][col])     // left to right
        rowStart++
        for (row in rowStart .. rowEnd) res.add(matrix[row][colEnd])       // top to bottom
        colEnd--
        if (rowStart <= rowEnd) for (col in colEnd downTo colStart) res.add(matrix[rowEnd][col])   // right to left
        rowEnd--
        if (colStart <= colEnd) for (row in rowEnd downTo rowStart) res.add(matrix[row][colStart]) // bottom to top
        colStart++
    }
    return res
}

fun main() {
    var matrix = arrayOf(intArrayOf(
            1, 2, 3), intArrayOf(
            4, 5, 6), intArrayOf(
            7, 8, 9))

    println(spiralOrder(matrix).joinToString())

    matrix = arrayOf(intArrayOf(
            1, 2, 3, 4), intArrayOf(
            5, 6, 7, 8), intArrayOf(
            9,10,11,12), intArrayOf(
            13,14,15,16))

     println(spiralOrder(matrix).joinToString())
}