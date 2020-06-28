package tech.hanfeng.algorithms.stack

import java.util.*


class BasicCalculatorIII {

    // used in both storing operation on the stack and perform operation calculation
    data class Operation(var total : Int, var prevOperand : Int, var operator : Char = '+', var operand : Int = 0)

    fun calculate(s: String): Int {
        val stack = Stack<Operation>()
        var total = 0
        var prevOperand = 0
        var operand = 0
        var opr = '+'
        for (ch in s) {
            when (ch) {
                in '0' .. '9' -> operand = operand * 10 + (ch - '0')
                '+', '-', '/', '*' -> {
                    val operation = performOperation(total, prevOperand, opr, operand)   // call to perform operation
                    total = operation.total
                    prevOperand = operation.prevOperand
                    opr = ch
                    operand = 0
                }
                '(' -> {
                    stack.push(Operation(total, prevOperand, opr))                   // push the operation on to stack
                    operand = 0                                                      // reset all values
                    opr = '+'
                    total = 0
                    prevOperand = 0
                }
                ')' -> {
                    val operation = performOperation(total, prevOperand, opr, operand)
                    operand = operation.total + operation.prevOperand
                    val topOperation = stack.pop()                                   // pop the top operation in the stack
                    total = topOperation.total                                       // set all values with top operation
                    prevOperand = topOperation.prevOperand
                    opr = topOperation.operator
                }
            }
        }
        val operation = performOperation(total, prevOperand, opr, operand)           // perform last operation
        return operation.total + operation.prevOperand
    }

    private fun performOperation(total: Int, prevOperand: Int, opr: Char, operand: Int): Operation {
        var total = total
        var prevOperand = prevOperand
        when (opr) {                       // calculate total and preOperand based on operator
            '+' -> {
                total += prevOperand
                prevOperand = operand
            }
            '-' -> {
                total += prevOperand
                prevOperand = -operand
            }
            '/' -> {
                prevOperand /= operand
            }
            '*' -> {
                prevOperand *= operand
            }
        }
        return Operation(total, prevOperand)
    }


    fun calculateR(s: String): Int {
        var i = 0
        fun helper(): Int {
            var sum = 0
            var prevOperand = 0
            var sign = '+'
            while (i < s.length) {
                val c = s[i]
                if (c == ' ') {
                    i++
                    continue
                }
                if (c.isDigit() || c == '(') {       // calculate sum only if number or ( is met
                    var operand : Int
                    if (c == '(') {
                        i++
                        operand = helper()
                    } else {                         // digits
                        operand = c - '0'
                        while (i + 1 < s.length && s[i + 1].isDigit())
                            operand = operand * 10 + (s[++i] - '0')
                    }

                    when (sign) {
                        '+', '-' -> {
                            sum += prevOperand
                            prevOperand = if (sign == '+') operand else -operand
                        }
                        '*' -> prevOperand *= operand
                        '/' -> prevOperand /= operand
                    }
                } else if (c == ')') {
                    break
                } else {
                    sign = c
                }
                i++
            }
            return sum + prevOperand
        }

        return helper()
    }
}

fun main() {
    val cal = BasicCalculatorIII()
    println(cal.calculateR("2*(5+5*2)/3+(6/2+8)"))
    println(cal.calculate("2 * (5+5*2)/3+(6/2+8)"))
}