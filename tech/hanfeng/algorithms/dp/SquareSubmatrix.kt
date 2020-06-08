package tech.hanfeng.algorithms.dp

class SquareSubmatrix {
    fun squareSubmatrix(arr : Array<BooleanArray>) : Int {
        var max = 0
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                if (arr[i][j])
                    max = Math.max(max, squareSubmatrix(arr,i,j))
            }
        }
        return max
    }

    fun squareSubmatrix(arr: Array<BooleanArray>, i : Int, j : Int) : Int {
        if (i == arr.size || j == arr[0].size) return 0

        if (!arr[i][j]) return 0

        return 1 + Math.min(Math.min(squareSubmatrix(arr,i+1,j),
                            squareSubmatrix(arr,i,j+1)),
                            squareSubmatrix(arr,i+1,j+1))
    }


    fun squareSubmatrixM(arr : Array<BooleanArray>) : Int {
        var cache = Array(arr.size){IntArray(arr[0].size)}

        var max = 0
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                if (arr[i][j])
                    max = Math.max(max, squareSubmatrixM(arr,i,j, cache))
            }
        }
        return max
    }

    fun squareSubmatrixM(arr: Array<BooleanArray>, i : Int, j : Int, cache : Array<IntArray>) : Int {
        if (i == arr.size || j == arr[0].size) return 0

        if (!arr[i][j]) return 0

        if (cache[i][j] > 0) return cache[i][j]

        cache[i][j] = 1 + Math.min(Math.min(squareSubmatrix(arr,i+1,j),
                squareSubmatrix(arr,i,j+1)),
                squareSubmatrix(arr,i+1,j+1))
        return cache[i][j]
    }


    fun squareSubmatrixDP(arr: Array<BooleanArray>) : Int {
        if (arr.isEmpty() || arr[0].isEmpty()) return 0

        var max = 0

        val dp = Array(arr.size){IntArray(arr[0].size)}

        for (i in arr.indices) {
            for(j in arr[0].indices) {
                if (i == 0 || j == 0) {
                    dp[i][j] = if (arr[i][j]) 1 else 0
                } else if (arr[i][j]) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                                                     dp[i - 1][j - 1]) + 1
                }
                max = Math.max(max, dp[i][j])
            }
        }
        return max
    }

    fun squareSubmatrixDPO(arr: Array<BooleanArray>) : Int {
        if (arr.isEmpty() || arr[0].isEmpty()) return 0

        val rows = arr.size
        val cols = arr[0].size
        val dp = IntArray(cols)
        var max = Int.MIN_VALUE
        var prev = 0

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                val tmp = dp[j]
                if (i == 0 || j == 0) {
                    dp[j] = if (arr[i][j]) 1 else 0
                } else if (arr[i-1][j-1]) {
                    dp[j] = Math.min(Math.min(dp[j - 1],prev), dp[j]) + 1
                    max = Math.max(max, dp[j])
                } else {
                    dp[j] = 0
                }
                prev = tmp
            }
        }
        return max
    }
}

fun main() {
    var matrix = arrayOf(booleanArrayOf(false, true, false, false),
            booleanArrayOf(true, true, true, true),
            booleanArrayOf(true, true, true, true),
            booleanArrayOf(true, true, true, true),
            booleanArrayOf(true, true, true, true)
    )

    println(SquareSubmatrix().squareSubmatrix(matrix))

    matrix = arrayOf(booleanArrayOf(false, true, false, false),
            booleanArrayOf(false, true, true, false),
            booleanArrayOf(false, true, true, false)
    )

    println(SquareSubmatrix().squareSubmatrixM(matrix))

    matrix = arrayOf(booleanArrayOf(false, true, true, false),
            booleanArrayOf(false, true, true, false),
            booleanArrayOf(false, true, false, false)
    )

    println(SquareSubmatrix().squareSubmatrixDP(matrix))

    matrix = arrayOf(booleanArrayOf(false, true, true, false),
            booleanArrayOf(false, true, true, false),
            booleanArrayOf(false, true, false, false)
    )

    println(SquareSubmatrix().squareSubmatrixDPO(matrix))

}