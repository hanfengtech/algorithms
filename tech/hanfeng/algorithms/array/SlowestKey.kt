package tech.hanfeng.algorithms

fun slowestKey(keyTimes: Array<Array<Int>>): Char {
    // Write your code here
    /*
    var max : Int
    var ch : Int

    if (keyTimes.size == 1) {
        ch = keyTimes[0][0]
        max = keyTimes[0][1]

        throw Exception("Illegal Arguments")
    }

    for (i in 1 until keyTimes.size) {
        val time = keyTimes[i][1] - keyTimes[i-1][1]
        if (time > max) {
            max = time
            ch = keyTimes[i][0]
        }
    }

    return 'a' + ch
    */
  return 'a'

}

fun minimumDivisor(arr: IntArray, threshold: Int): Int {
    var divisor = 1
    var sum = 0

    do {
        sum = 0
        for (i in arr.indices) {
            sum += Math.ceil(arr[i].toDouble() / divisor).toInt()
        }

        divisor++
    } while (sum > threshold)

    return divisor - 1
}

fun main() {

    println(minimumDivisor(intArrayOf(2,4,5),10))
}