package tech.hanfeng.algorithms.strings

fun isValidPalindrome(s : CharSequence) : Boolean {
    var i = 0
    var j = s.length - 1

    while (i < j) {
        if (s[i++] != s[j--]) {
            return false
        }
    }
    return true
}

fun validPalindrome(s: String): Boolean {
    val sb = StringBuilder(s)
    for (i in s.indices) {
        var ch = sb[i]
        sb.deleteCharAt(i)
        if (isValidPalindrome(sb)) {
            return true
        }
        sb.insert(i, ch)
    }
    return false
}


fun isPalindromeRange(s : String, i : Int, j : Int) : Boolean {
    var l = i
    var r = j
    while (l < r) {
        if (s[l] != s[r])
            return false
    }
    return true
}

fun validPalindromeGreedy(s : String) : Boolean {
    var i = 0
    val n = s.length / 2
    var j = s.length - 1
    while (i < n) {
        if (s[i] != s[j]) {
            return isPalindromeRange(s, i + 1, j) ||
                    isPalindromeRange(s, i, j - 1)
        }
        i++
        j--
    }
    return true
}


fun main() {
    println(validPalindrome("ada"))
    println(validPalindrome("adca"))

    println(validPalindromeGreedy("adda"))
    println(validPalindromeGreedy("adcefcda"))

    println(validPalindromeGreedy("adcegfcda"))
}
