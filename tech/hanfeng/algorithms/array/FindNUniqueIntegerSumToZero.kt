package tech.hanfeng.algorithms.array

import kotlin.random.Random

fun sumZero(n: Int): IntArray {
    var i = 0
    var j = n - 1
    var num = n / 2
    var res = IntArray(n)

    while (i < j) {
        res[i] = -num
        res[j] = num
        i++
        j--
        num--
    }

    if (i == j) res[i] = 0

    return res.shuffle()
}

fun IntArray.shuffle(): IntArray {
    for (index in this.indices) {
        val randomIndex = Random.nextInt(index+1)

        // Swap with the random position
        val temp = this[index]
        this[index] = this[randomIndex]
        this[randomIndex] = temp
    }

    return this
}

fun main() {
    println(sumZero(5).contentToString())
}