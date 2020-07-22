package tech.hanfeng.algorithms.strings

fun canPermutePalindrome(s: String) : Boolean {
    var set = HashSet<Char>()
    for (i in s.indices) {
        if (!set.add(s[i]))
            set.remove(s[i])
    }
    return set.size <= 1
}

fun main() {
    println(canPermutePalindrome("code"))
    println(canPermutePalindrome("aab"))
    println(canPermutePalindrome("carerac"))
}