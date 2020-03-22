package tech.hanfeng.algorithms.strings

fun reverseVowels(s: String): String {

    var a = s.toCharArray()

    var i = 0
    var j = s.length - 1

    val vowels = HashSet(arrayListOf('a','e','i','o','u'))

    while (i < j) {
        while (i < j && !vowels.contains(a[i].toLowerCase())) i++
        while (j > i && !vowels.contains(a[j].toLowerCase())) j--
        swap(a, i++, j--)
    }

    return String(a)
}

fun main() {
    println(reverseVowels("leetcode"))
}