package tech.hanfeng.algorithms.matrix

fun multiply(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
    val output = Array(A.size) { IntArray(B[0].size)}
    for (i in A.indices) {
        for (j in A[0].indices) {
            if (A[i][j] != 0) {
                for (k in B[0].indices) {
                    if (B[j][k] != 0) {
                        output[i][k] += A[i][j] * B[j][k]
                    }
                }
            }
        }
    }

    return output
}