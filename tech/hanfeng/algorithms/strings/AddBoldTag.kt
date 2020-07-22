package tech.hanfeng.algorithms.strings

fun addBoldTag(s: String, dict: Array<String>): String {
    val n = s.length
    val bold = BooleanArray(s.length)
    var end = 0

    for (i in s.indices) {
        for (word in dict) {
            if (s.startsWith(word, i))
                end = maxOf(end, i + word.length)
        }
        bold[i] = end > i
    }

    val res = StringBuilder()
    var i = 0
    while(i < n) {
        if (!bold[i]) {
            res.append(s[i++])
            continue
        }
        var j = i
        while(j < n && bold[j]) j++
        res.append("<b>")
        res.append(s.subSequence(i,j))
        res.append("</b>")
        i = j - 1
        i++
    }
    return res.toString()
}

fun main() {
    println(addBoldTag("abcxyz123", arrayOf("abc", "123")))
    println(addBoldTag("abcxyz123", arrayOf("abc", "xyz", "12")))
}