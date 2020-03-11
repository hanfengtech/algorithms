package tech.hanfeng.algorithms.implementation

import java.util.*

/**
 *   define class with constructor(K)
 *
 *   add(x)
 *
 *   get()  return the product of last k elements
 *
 */


class LastProduct{
    var k: Int
    var values = LinkedList<Int>()
    var zeros = 0
    var product : Int = 1

    constructor(k : Int) {
        this.k = k
    }

    fun add(x : Int) {              // O(1)
        if (values.size == k) {     // size reached k
            val dump = values.poll()
            if (zeros > 0) {  // there are zeros
                zeros--
            } else {  // there are no zeros
                product /= dump
            }
        }

        values.offer(x)
        if (x == 0) {
            zeros = values.size
            product = 1
        } else {
            product *= x
        }
    }

    fun get() : Int {                //  O(1)
        return if (values.size != 0) {
            if (zeros > 0) {
                0
            } else {
                product
            }
        } else {
            0
        }
    }
}

fun main() {
    var lp = LastProduct(3)
    println(lp.get())

    lp.add(1)
    lp.add(2)

    println(lp.get())

    lp.add(3)
    lp.add(0)
    println(lp.get())

    lp.add(5)
    println(lp.get())

    lp.add(6)
    println(lp.get())

    lp.add(2)
    println(lp.get())

    lp.add(2)
    println(lp.get())

    lp.add(0)
    println(lp.get())
}