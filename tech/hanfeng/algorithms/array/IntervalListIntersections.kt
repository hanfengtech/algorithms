package tech.hanfeng.algorithms.array

fun intervalIntersections(A : Array<IntArray>, B : Array<IntArray>) : Array<IntArray> {
    val result = ArrayList<IntArray>()

    val n = A.size
    val m = B.size

    var i = 0
    var j = 0

    while (i < n && j < m) {
        val lo = Math.max(A[i][0], B[j][0])
        val hi = Math.min(A[i][1], B[j][1])

        if (lo <= hi)
            result.add(intArrayOf(lo, hi))

        if (A[i][1] < B[j][1]) {
            i++
        } else {
            j++
        }
    }
    return result.toTypedArray()
}

fun main() {
    //  A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]

    val A = arrayOf( intArrayOf(0,2),intArrayOf(5,10),
            intArrayOf(13,23),intArrayOf(24,25))

    val B = arrayOf( intArrayOf(3,4),intArrayOf(8, 12),
            intArrayOf(15,24),intArrayOf(25,26))

    val list = intervalIntersections(A, B)
    list.forEach{
        println(it.contentToString())
    }
}