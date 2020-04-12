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

fun longestCommonPrefixB(strs: Array<String>) : String {
    if (strs.isEmpty()) return ""

    val result = StringBuilder()

    val n = strs[0].length

    for (i in 0 until n) {
        val ch = strs[0][i]
        for (j in 1 until strs.size) {
            if (i == strs[j].length || strs[j][i] != strs[0][i]) {
                return result.toString()
            }
        }
        result.append(ch)
    }

    return result.toString()
}

fun main() {

    println(longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(longestCommonPrefixB(arrayOf("flower","flow","flight")))

    val strings = arrayOf("How are you doing?", "How are you going to do this?", "How are you dealing with the situation?")

    println(longestCommonPrefix(strings))
}