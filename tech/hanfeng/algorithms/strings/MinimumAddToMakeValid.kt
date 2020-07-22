package tech.hanfeng.algorithms.strings

fun minAddToMakeValid(s : String) : Int {
    var left = 0
    var right = 0
    s.forEach {
        when (it) {
            '(' -> left++
            else -> {
                if (left == 0) right++
                else left--
            }
        }
    }
    return right + left
}

fun main() {
    println(minAddToMakeValid("(()"))
    println(minAddToMakeValid("((("))
    println(minAddToMakeValid("()"))
    println(minAddToMakeValid("()))(("))
}