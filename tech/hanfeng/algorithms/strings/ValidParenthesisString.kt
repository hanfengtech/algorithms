package tech.hanfeng.algorithms.strings

fun checkValidString(s: String): Boolean {
    var lo = 0
    var hi = 0
    for (c in s.toCharArray()) {
        lo += if (c == '(') 1 else -1
        hi += if (c != ')') 1 else -1
        if (hi < 0) break     // handle extra )
        lo = Math.max(lo, 0)  // handle reset on * or )
    }
    return lo == 0
}

fun main() {
    println(checkValidString("((()))*"))
    println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"))
}