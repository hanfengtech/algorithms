package tech.hanfeng.algorithms.strings

fun reverseWordsKeepOrder(s : String) : String {
    val arr = s.toCharArray()
    reverseWord(arr)
    return String(arr)
}

fun main() {
    println(reverseWordsKeepOrder("Let's take LeetCode contest"))
}