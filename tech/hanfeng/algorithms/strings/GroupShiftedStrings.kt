package tech.hanfeng.algorithms.strings

fun groupStrings(strings : Array<String>) : List<List<String>> {
    val groups = HashMap<String, ArrayList<String>>()
    for (s in strings) {
        groups.getOrPut(hashString(s), { ArrayList() }).add(s)
    }

    return groups.values.toList()
}

fun hashString(s : String) : String {
    if (s.length == 1) return ""

    val sb = StringBuilder()
    for (i in 1 until s.length) {
        val diff = s[i] - s[i - 1]
        sb.append(if (diff < 0) diff + 26 else diff).append(":")
    }
    return sb.toString()
}

fun main() {
    val result = groupStrings(arrayOf("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"))
    result.forEach {
        println(it.joinToString())
    }
}