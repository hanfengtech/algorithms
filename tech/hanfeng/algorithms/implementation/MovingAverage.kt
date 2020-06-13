package tech.hanfeng.algorithms.implementation

import java.util.*

class MovingAverage(size: Int) {

    private var queue = LinkedList<Int>()
    private var capacity = 0
    private var sum = 0.0

    init {
        queue = LinkedList()
        capacity = size
    }

    fun next(`val`: Int): Double {
        if (queue.size == capacity) {
            sum -= queue.remove()
        }
        sum += `val`
        queue.add(`val`)

        return sum / queue.size
    }
}

fun main() {
    val movingAverage = MovingAverage(3)
    println(movingAverage.next(1))
    println(movingAverage.next(10))
    println(movingAverage.next(3))
    println(movingAverage.next(5))
}