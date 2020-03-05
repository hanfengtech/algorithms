package tech.hanfeng.algorithms.recursion

fun letterCombination(digits : String) : List<String> {
    val resList = ArrayList<String>()
    if (digits.isEmpty()) return resList

    val map = mapOf('2' to arrayOf("a", "b", "c"),
            '3' to arrayOf("d", "e", "f"),
            '4' to arrayOf("g", "h", "i"),
            '5' to arrayOf("j", "k", "l"),
            '6' to arrayOf("m", "n", "o"),
            '7' to arrayOf("p", "q", "s", "r"),
            '8' to arrayOf("t", "u", "v"),
            '9' to arrayOf("w", "x", "y", "z")
    )

    fun helper(slate : StringBuilder, i : Int) {
        if (i == digits.length) {
            resList.add(slate.toString())
            return
        }
        val letters = map[digits[i]]
        if (letters != null) {
            for (letter in letters) {
                slate.append(letter)
                helper(slate, i + 1)
                slate.deleteCharAt(slate.lastIndex)
            }
        }
    }

    helper(StringBuilder(), 0)
    return resList
}

fun main() {
    println(letterCombination("23"))
}