package tech.hanfeng.algorithms.strings

fun validWordAbbreviation(word : String, abbr : String) : Boolean {
    var i = 0
    var count = 0

    for (ch in abbr) {
        if (Character.isDigit(ch)){
            if (ch == '0' && count == 0) return false
            count = count * 10 + (ch - '0')
        } else {
            i += count
            if (i >= word.length || word[i] != ch) return false
            i++
            count = 0
        }
    }
    return i + count == word.length
}

fun main() {
    println(validWordAbbreviation("a", "01"))
    println(validWordAbbreviation("internationalization", "i12iz4n"))
    println(validWordAbbreviation("apple", "a2e"))
}