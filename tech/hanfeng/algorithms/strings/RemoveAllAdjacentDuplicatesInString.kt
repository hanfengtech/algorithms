package tech.hanfeng.algorithms.strings

import java.lang.StringBuilder

fun removeDuplicates(S: String): String {
    var sb = StringBuilder()

    S.forEach{
        if (sb.isNotEmpty() && it == sb[sb.lastIndex]) {
            sb.deleteCharAt(sb.lastIndex)
        } else {
            sb.append(it)
        }
    }

    return sb.toString()
}

fun main() {
    println(removeDuplicates("abbaca"))
}