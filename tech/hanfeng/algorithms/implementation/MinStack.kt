package tech.hanfeng.algorithms.implementation

import java.util.*

class MinStack {

    /** initialize your data structure here. */
    private val stack = LinkedList<Int>()
    private var min = Integer.MAX_VALUE

    fun push(x: Int) {
        if (x <= min) {
            stack.push(min)
            min = x
        }
        stack.push(x)
    }

    fun pop() {
        if (stack.size > 0) {
            if (stack.pop() == min)
                min = stack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return if (stack.size > 0) {
            min
        } else {
            Integer.MIN_VALUE
        }
    }
}

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.top())
    println(minStack.getMin())
    minStack.pop()
    minStack.pop()
    minStack.pop()
    println(minStack.getMin())
    minStack.pop()
    println(minStack.getMin())

}