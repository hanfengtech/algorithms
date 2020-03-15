package tech.hanfeng.algorithms.strings

import java.lang.Exception

fun strStr(haystack : String, needle : String) : Int {
    for (i in 0 .. haystack.length) {
        for (j in 0 .. needle.length) {
            if (j == needle.length) {
                return i
            }

            if (i + j == haystack.length) {
                return -1
            }

            if (needle[j] != haystack[i + j])
                break
        }
    }
    throw Exception("Should not be here!")
}

fun main() {
    println(strStr("How are you doing?", "you"))
    println(strStr("Where are you?", "Here"))
    println(strStr("", ""))
}