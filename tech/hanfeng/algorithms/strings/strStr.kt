package tech.hanfeng.algorithms.strings

fun strStr(haystack : String, needle : String) : Int {
    for (i in 0 .. haystack.length) {
        for (j in 0 .. needle.length) {
            if (j == needle.length) {
                return i
            }

            if (i + j == haystack.length) {
                return -1
            }

            val a = needle[j]
            val b = haystack[i + j]
            if (a != b)
                break
        }
    }
    return 0
}

fun main() {
    println(strStr("How are you doing?", "you"))
    println(strStr("Where are you?", "Here"))
    println(strStr("", ""))
}