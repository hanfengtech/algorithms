package tech.hanfeng.algorithms.array

import java.util.*

fun largestRectangleArea(heights: IntArray): Int {
    val stack = LinkedList<Int>()
    var maxArea = 0
    var topIndex : Int
    var areaWithTop : Int
    var i = 0

    fun calculateArea() {
        topIndex = stack.pop()
        areaWithTop = heights[topIndex] * (if (stack.isEmpty()) i else i - stack.peek() - 1)

        if (maxArea < areaWithTop) {
            maxArea = areaWithTop
        }
    }

    while(i < heights.size) {
        if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
            stack.push(i++)
        } else {
            calculateArea()
        }
    }

    while(stack.isNotEmpty()) {
        calculateArea()
    }

    return maxArea
}

fun main() {
    println(largestRectangleArea(intArrayOf(6,2,5,5,4,5,1,6)))
    println(largestRectangleArea(intArrayOf(2,1,5,6,2,3)))
}