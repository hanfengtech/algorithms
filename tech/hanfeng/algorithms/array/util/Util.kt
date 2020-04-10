package tech.hanfeng.algorithms.array.util

fun printMatrix(M : Array<IntArray>) {
    for (i in M.indices) {
        for (j in M[i].indices) {
            print(M[i][j])
            if (j < M[i].size)
                print(",")
        }
        println()
    }
}