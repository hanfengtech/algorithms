package tech.hanfeng.algorithms.recursion

import java.util.*
import kotlin.collections.ArrayList

fun letterPermutation(S: String) : List<String> {
    val resList = ArrayList<String> ()

    fun helper(slate : StringBuilder, i : Int) {
        if (i == S.length) {
            resList.add(slate.toString())
            return
        }

        if (S[i].isDigit()) {
            slate.append(S[i])
            helper(slate, i + 1)
            slate.removeLast()
        } else {
            slate.append(S[i].toLowerCase())
            helper(slate, i + 1)
            slate.removeLast()

            slate.append(S[i].toUpperCase())
            helper(slate, i + 1)
            slate.removeLast()
        }
    }

    helper(StringBuilder(), 0)
    return resList
}

fun StringBuilder.removeLast() {
    deleteCharAt(lastIndex)
}

fun main() {
    println(letterPermutation("a1b2"))
}

