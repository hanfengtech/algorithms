package tech.hanfeng.algorithms.strings

fun lengthOfLastWord(s : String) : Int {
    val str = s.trim()
    val spaceIndex = str.lastIndexOf(' ')
    return str.length - spaceIndex - 1
}

fun main() {
    println(lengthOfLastWord("Hello World"))
}