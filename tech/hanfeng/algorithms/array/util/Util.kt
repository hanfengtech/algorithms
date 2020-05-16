package tech.hanfeng.algorithms.array.util

fun printMatrix(M : Array<IntArray>) {
    for (i in M.indices) {
        for (j in M[i].indices) {
            print(M[i][j])
            if (j < M[i].size - 1)
                print(",")
        }
        println()
    }
}

fun printMatrix(M : Array<BooleanArray>) {
    for (i in M.indices) {
        for (j in M[i].indices) {
            if (M[i][j]) {
                print('T')
            } else {
                print('F')
            }
            if (j < M[i].size - 1)
                print(",")
        }
        println()
    }
}