package tech.hanfeng.algorithms.strings

import java.util.*

fun longestValidParentheses(s : String) : Int {
    var max = 0
    val stack = LinkedList<Int>()
    stack.push(-1)
    for (i in s.indices) {
        if (s[i] == '(') {
            stack.push(i)
        } else {   //  see an ')'
            stack.pop()
            if (stack.isEmpty()) {
                stack.push(i)
            } else {
                max = maxOf(max, i - stack.peek())
            }
        }
    }

    return max
}

fun main() {
    println(longestValidParentheses("())((())"))
    println(longestValidParentheses("()"))
}