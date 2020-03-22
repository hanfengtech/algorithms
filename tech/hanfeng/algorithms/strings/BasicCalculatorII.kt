package tech.hanfeng.algorithms.strings

import java.util.*

fun calculate(s : String) : Int {
    if (s.isEmpty())
        return 0

    var len = s.length
    val stack = Stack<Int>()
    var num = 0
    var sign = '+'

    for (i in s.indices) {
        val c = s[i]
        if (Character.isDigit(c)) {
            num = num * 10 + (c - '0')
        }

        if ((!Character.isDigit(c)) && c != ' ' || i == len - 1) {
            when(sign) {
                '-' -> {
                    stack.push(-num)
                }
                '+' -> {
                    stack.push(num)
                }
                '*' -> {
                    stack.push(stack.pop() * num)
                }
                '/' -> {
                    stack.push(stack.pop() / num)
                }
            }
            sign = c
            num = 0
        }
    }

    var result = 0
    for (i in stack) {
        result += i
    }
    return result
}

fun main() {
    println(calculate("3+2*2"))
    println(calculate("3/2"))
    println(calculate("3+2*2"))
    println(calculate("31+2*2"))
}