package tech.hanfeng.algorithms.strings

import java.util.*

fun longestCommonPrefix(strs: Array<String>) : String {
    val result = StringBuilder()

    if (strs.isNotEmpty()) {
        Arrays.sort(strs)

        val a = strs[0].toCharArray()
        val b = strs[strs.size - 1].toCharArray()

        for(i in a.indices) {
            if (i < b.size && b[i] == a[i]) {
                result.append(b[i])
            } else {
                return result.toString()
            }
        }
    }
    return result.toString()
}

fun main() {
    val strings = arrayOf("How are you doing?", "How are you going to do this?", "How are you dealing with the situation?")

    println(longestCommonPrefix(strings))
}