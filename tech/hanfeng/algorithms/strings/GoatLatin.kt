package tech.hanfeng.algorithms.strings

fun toGoatLatin(S: String): String {
    val res = StringBuilder()
    val strs = S.split(" ")
    for (i in strs.indices) {
        val sb = StringBuilder(strs[i])
        if(!isVowel(sb[0])) {
            val ch = sb[0]
            sb.deleteCharAt(0)
            sb.append(ch)
        }
        sb.append("ma")

        var count = 0
        while( count < i + 1) {
            sb.append("a")
            count++
        }

        res.append(sb.toString())

        if (i < strs.size - 1) {
            res.append(" ")
        }
    }

    return res.toString()
}

fun isVowel(ch : Char) : Boolean {
    return when (ch) {
        'a', 'e', 'i', 'o', 'u','A', 'E','I','O','U' -> true
        else -> false
    }
}

fun main() {
    println(toGoatLatin("I speak Goat Lation"))
}