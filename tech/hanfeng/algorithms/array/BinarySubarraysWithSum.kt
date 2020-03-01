package tech.hanfeng.algorithms.array

fun numSubarraysWithSumB(A: IntArray, S: Int): Int {
    if (A.isEmpty()) return 0
    var count = 0
    var tmpSum = 0

    var i = 0
    var j = 0

    while (j < A.size) {
        tmpSum += A[j++]
        if (tmpSum == S) {
            count++
            break
        }
    }

    if (j == A.size) return count

    var addFlag = true

    while(i <= j) {

        if (addFlag) {
            tmpSum += A[j]
        }

        if (tmpSum == S) {  // still equals to sum
            if (j < A.size-1) {
                j++
                addFlag = true
            } else {
                i++
            }
            count++
        } else if (tmpSum > S){  // bigger than sum
            tmpSum -= A[i]
            i++
            addFlag = false
        } else if (tmpSum < S) {
            break
        }
    }

    return count
}

fun numSubarraysWithSum(A: IntArray, S: Int): Int {
    var iLo = 0
    var iHi = 0
    var sumLo = 0
    var sumHi = 0
    var ans = 0
    for (j in A.indices) { // While sumLo is too big, iLo++
        sumLo += A[j]
        while (iLo < j && sumLo > S) {
            sumLo -= A[iLo]
            iLo++
        }
        // While sumHi is too big, or equal and we can move, iHi++
        sumHi += A[j]
        while (iHi < j && (sumHi > S || sumHi == S && A[iHi] == 0)) {
            sumHi -= A[iHi]
            iHi++
        }
        if (sumLo == S) {
            ans += iHi - iLo + 1
        }
    }
    return ans
}

fun main() {
//    println(numSubarraysWithSum(intArrayOf(1,0,1,0,1), 1))
    println(numSubarraysWithSum(intArrayOf(1,0,1,0,1), 2))
}