package tech.hanfeng.algorithms.others

import java.util.*

fun getPermutation(n: Int, k: Int): String {
    var total = 1
    val list = LinkedList<Int>()
    (1..n).forEach {
        total *= it
        list.add(it)
    }

    var order = k
    val stringBuilder = StringBuilder()
    while (list.isNotEmpty()) {
        total /= list.size
        val curOrder = (order - 1) / total
        stringBuilder.append(list.removeAt(curOrder))
        order -= curOrder * total
    }

    return stringBuilder.toString()
}

fun main() {
    println(getPermutation(3,3))
}