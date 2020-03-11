package tech.hanfeng.algorithms.implementation

import java.lang.ArithmeticException
import java.util.*

/**
 *   define class with constructor(K)
 *
 *   add(x)
 *
 *   get()  return the product of last k elements
 *
 */


class LastProduct {
    var k: Int
    var values = LinkedList<Int>()
    var zeros = 0
    var max = 0
    var product: Int = 1

    constructor(k: Int) {
        this.k = k
    }

    fun add(x: Int) {              // O(1)
        if (values.size == k) {     // size reached k
            val dump = values.poll()
            if (zeros > 0) {  // there are zeros
                zeros--
            } else {  // there are no zeros
                if (max > 0) {
                    max--
                } else {
                    product /= dump
                }
            }
        }

        values.offer(x)
        if (x == 0) {   // has zeros
            zeros = values.size
            product = 1
            max = 0
        } else {        // no zeros
            product = try {
                Math.multiplyExact(product, x)
            } catch (ae: ArithmeticException) {
                max = values.size
                1
            }
        }
    }

    fun get(): Int {                //  O(1)
        if (values.size == 0)
            return 0

        if (zeros > 0)
            return 0

        if (max > 0)
            return Int.MAX_VALUE

        return product
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

    lp.add(Int.MAX_VALUE)
    println(lp.get())

    lp.add(2)
    println(lp.get())

    lp.add(3)
    println(lp.get())

    lp.add(2)
    println(lp.get())

    lp.add(Int.MAX_VALUE)
    println(lp.get())

    lp.add(0)
    println(lp.get())

    lp.add(4)
    println(lp.get())

    lp.add(5)
    println(lp.get())

    lp.add(5)
    println(lp.get())

}