package tech.hanfeng.algorithms.array

import java.util.*

class KthLargestInStream(var k: Int, nums: IntArray) {

    val pq = PriorityQueue<Int>()

    init {
        nums.forEach {
            addTo(it)
        }
    }

    fun addTo(`val` : Int){
        if (pq.size < k) {
            pq.offer(`val`)
        } else {
            if (`val` > pq.peek()) {
                pq.poll()
                pq.offer(`val`)
            }
        }
    }

    fun add(`val`: Int): Int {
        addTo(`val`)
        return pq.peek()
    }
}

fun main() {
    val klargest = KthLargestInStream(3, intArrayOf(4,5,8,2))
    println(klargest.add(3))
    println(klargest.add(5))
    println(klargest.add(10))
    println(klargest.add(9))
    println(klargest.add(4))
}
