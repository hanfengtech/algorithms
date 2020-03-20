package tech.hanfeng.algorithms.strings

fun isPalindrome(s : String) : Boolean {
    if (s.isEmpty()) return true

    var i = 0
    var j = s.length - 1

    var iCh:Char
    var jCh:Char

    while (i <= j) {
        iCh = s[i]
        jCh = s[j]

        if (!Character.isLetterOrDigit(iCh)) {
            i++
        } else if (!Character.isLetterOrDigit(jCh)) {
            j--
        } else {
            if (Character.toLowerCase(iCh) != Character.toLowerCase(jCh)) {
                return false
            }
            i++
            j--
        }
    }
    return true
}

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
}