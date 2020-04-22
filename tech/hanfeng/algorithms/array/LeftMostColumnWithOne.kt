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
    val y = dim!![0]
    val x = dim[1]

    var i = 0
    var j = x - 1
    var res = -1

    while (i < y && j >= 0) {
        if (binaryMatrix.get(j, i) == 0) {
            i++
        } else {
            res = j
            j--
        }
    }

    return res
}

fun main() {
    println(leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(0,1)))))
    println(leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(0,0)))))
    println(leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0), intArrayOf(1,1)))))
    println(leftMostColumnWithOne(BinaryMatrix(arrayOf(intArrayOf(0,0,0,1), intArrayOf(0,0,1,1), intArrayOf(0,1,1,1)))))
}