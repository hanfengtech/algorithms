package tech.hanfeng.algorithms.strings

fun countSegments(s : String) : Int {
    if (s.isEmpty())
        return 0

    var seg = 0

    for (i in s.indices) {
        if (s[i] != ' ' && (i == 0 || s[i - 1] == ' '))
            seg++
    }

    return seg
}

fun main() {
    println(countSegments("Hello, my name is John"))
    println(countSegments("  Hello, my name is John"))
    println(countSegments("    "))
}