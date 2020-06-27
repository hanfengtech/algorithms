package tech.hanfeng.algorithms.stack

import java.util.*

class BasicCalculator {
    fun calculate(s: String): Int {
        var stack = Stack<Int>()
        var operand = 0
        var evaluation = 0
        var sign = 1          // 1 means positive, -1 means negative

        for (ch in s) {
            when {
                Character.isDigit(ch) -> operand = 10 * operand + (ch - '0')   // cal operand
                ch == '+' -> {
                    evaluation += sign * operand      // perform the evaluation with last recorded sign and operand
                    sign = 1                          // set sign to positive
                    operand = 0                       // reset operand
                }
                ch == '-' -> {
                    evaluation += sign * operand
                    sign = -1                         // set sign to negative
                    operand = 0
                }
                ch == '(' -> {
                    stack.push(evaluation)            // push the evaluation onto the stack
                    stack.push(sign)                  // push sign onto the stack
                    sign = 1                          // reset the sign
                    evaluation = 0                    // reset evaluation
                }
                ch == ')' -> {
                    evaluation += sign * operand
                    evaluation *= stack.pop()         // pop the sign and apply to the evaluation
                    evaluation += stack.pop()         // pop the evaluation on stack and add to the current evaluation
                    operand = 0
                }
            }
        }
        return evaluation + sign * operand            // evaluate last operand
    }
}

fun main() {
    val calculator = BasicCalculator()
    println(calculator.calculate("1 + 1"))
    println(calculator.calculate("2 - 1 + 2"))
    println(calculator.calculate("(1+(4+5+2)-3)+(6+8)"))

}