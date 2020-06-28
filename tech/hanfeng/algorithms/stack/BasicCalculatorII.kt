package tech.hanfeng.algorithms.stack

import java.util.*

fun calculate(s : String) : Int {
    var len = s.length
    val stack = Stack<Int>()
    var operand = 0
    var sign = '+'

    for (i in s.indices) {
        val ch = s[i]
        if (ch.isDigit()) {
            operand = operand * 10 + (ch - '0')
        }

        if ((!ch.isDigit()) && ch != ' ' || i == len - 1) {
            when(sign) {
                '-' -> {
                    stack.push(-operand)
                }
                '+' -> {
                    stack.push(operand)
                }
                '*' -> {
                    stack.push(stack.pop() * operand)
                }
                '/' -> {
                    stack.push(stack.pop() / operand)
                }
            }
            sign = ch
            operand = 0
        }
    }

    var result = 0
    for (i in stack) {
        result += i
    }
    return result
}

fun calculate2(s: String): Int {
    var start = 0
    if (s.isEmpty()) return 0
    var operand = '+'
    var prev = 0
    var total = 0
    while (start >= 0 && start < s.length) {
        val curr = s[start]
        if (curr.isDigit()) {
            var k = curr - '0'
            while (start + 1 < s.length && s[start + 1].isDigit()) {
                k = k * 10 + (s[start + 1] - '0')
                start++
            }
            if (operand == '+') {
                total += prev
                prev = k
            } else if (operand == '-') {
                total += prev
                prev = -1 * k
            } else if (operand == '*') {
                prev *= k
            } else if (operand == '/') {
                prev /= k
            } else {
                throw IllegalArgumentException("invalid operand type. only +, -, /, * allowed.")
            }
        } else if (isOperand(curr)) {
            operand = curr
        }
        start++
    }
    total += prev
    return total
}

fun isOperand(chr: Char): Boolean {
    return chr == '+' || chr == '-' || chr == '*' || chr == '/'
}

fun main() {
    println(calculate2("3+2*2"))
    println(calculate("3/2"))
    println(calculate("3+2*2"))
    println(calculate("31+2*2"))
}