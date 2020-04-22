package tech.hanfeng.algorithms.array

class BinaryMatrix(var matrix : Array<IntArray>) {

    private var dimension : ArrayList<Int>? = null

    init {
        dimension = ArrayList()
        dimension?.add(matrix.size)
        dimension?.add(matrix[0].size)
    }

    fun get(x: Int, y: Int) : Int {
        return matrix[y][x]
    }

    fun dimensions(): ArrayList<Int>? {
        return dimension
    }

}

fun leftMostColumnWithOne(binaryMatrix : BinaryMatrix) : Int {
    val dim = binaryMatrix.dimensions()
    val n = dim!![0]
    val m = dim[1]

    var y = 0
    var x = m - 1
    var col = -1

    while (y < n && x >= 0) {
        if (binaryMatrix.get(x, y) == 0) {
            y++
        } else {
            col = x
            x--
        }
    }

    return col
}

fun main() {
    println(leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(0,1)))))
    println(leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(0,0)))))
    println(leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(1,1)))))
    println(leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0,0,1), intArrayOf(0,0,1,1), intArrayOf(0,1,1,1)))))
}