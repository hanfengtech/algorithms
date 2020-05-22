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

fun isValidParenthesesGreedy(s: String): Boolean {
    var lo = 0
    var hi = 0
    for (c in s.toCharArray()) {
        lo += if (c == '(') 1 else -1
        hi += if (c != ')') 1 else -1
        if (hi < 0) break
        lo = Math.max(lo, 0)
    }
    return lo == 0
}

fun main() {
    println(isValidParentheses("(()(())())"))

}