package tech.hanfeng.algorithms.matrix

fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
    if (matrix.isEmpty()) return false

    if (matrix.size == 1) {
        return true
    }

    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[0].size) {
            if (matrix[i][j] != matrix[i-1][j-1]) return false
        }
    }

    return true
}

fun main() {
    var matrix = arrayOf(intArrayOf(
        1,2,3,4), intArrayOf(
        5,1,2,3), intArrayOf(
        9,5,1,2))

    println(isToeplitzMatrix(matrix))
}