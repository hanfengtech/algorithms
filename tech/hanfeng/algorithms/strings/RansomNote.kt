package tech.hanfeng.algorithms.strings

fun canConstruct(ransomNote : String, magazine : String) : Boolean {
    var chars = IntArray(26) { 0 }

    for (i in magazine.indices) {
        chars[magazine[i] - 'a']++
    }

    for (i in ransomNote.indices) {
        if (--chars[ransomNote[i] - 'a'] < 0) {
            return false
        }
    }

    return true
}

fun main() {
    println(canConstruct("a", "b"))
    println(canConstruct("aa", "ab"))
    println(canConstruct("aa", "aab"))
}