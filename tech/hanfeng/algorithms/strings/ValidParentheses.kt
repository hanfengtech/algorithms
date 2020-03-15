package tech.hanfeng.algorithms.strings

import java.util.*

fun isValidParentheses(s : String) : Boolean {
    val stack = LinkedList<Char>()
    for (c in s.toCharArray()) {
        when(c) {
            '(' -> { stack.push(')')}
            '{' -> { stack.push('}')}
            '[' -> { stack.push(']')}
            else -> {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false
                }
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValidParentheses("(()(())())"))

}