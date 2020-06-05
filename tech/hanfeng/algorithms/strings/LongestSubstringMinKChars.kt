package tech.hanfeng.algorithms.strings

fun longestSubstringMinKCharsRegex(s: String, k: Int): Int {
    val counter = IntArray(26)
    for (c in s.toCharArray()) {
        counter[c - 'a']++
    }
    var regex = StringBuilder("[")
    for (i in counter.indices) {
        if (counter[i] in 1 until k) {
            regex.append((i + 'a'.toInt()).toChar())
        }
    }
    regex.append("]+")

    // if the regex string didn't change, that means there were no chars less than k count
    if (regex.length == 3) {
        return s.length
    }
    val split = s.split(regex.toString().toRegex()).toTypedArray()
    var largestSplit = 0
    for (newString in split) {
        largestSplit = Math.max(largestSplit, longestSubstringMinKCharsRegex(newString, k))
    }
    return largestSplit
}

fun longestSubstringMinKChars(s: String, k: Int): Int {
    var d = 0
    for (uniqueCharsTarget in 1..26) {
        if (uniqueCharsTarget <= s.length) {
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, uniqueCharsTarget))
        }
    }

    return d
}

fun longestSubstringWithNUniqueChars(s: String, k: Int, uniqueCharsTarget: Int): Int {
    val map = IntArray(128)
    var uniqueChars = 0 // counter 1 to count number of unique chars
    var charsKorMoreCount = 0 // counter 2 to count chars with k or more count
    var begin = 0
    var end = 0
    var d = 0
    while (end < s.length) {
        val endChar = s[end]
        if (map[endChar.toInt()] == 0) {
            uniqueChars++
        }
        map[endChar.toInt()]++
        // if curr freq reached k we incr the charsKorMoreCount items
        if (map[endChar.toInt()] == k) {
            charsKorMoreCount++
        }
        end++

        while (uniqueChars > uniqueCharsTarget) {
            val beginChar = s[begin]
            if (map[beginChar.toInt()] == k) {
                charsKorMoreCount--
            }
            map[beginChar.toInt()]--
            if (map[beginChar.toInt()] == 0) {
                uniqueChars--
            }
            begin++
        }

        if (uniqueChars == uniqueCharsTarget && uniqueChars == charsKorMoreCount) d = Math.max(end - begin, d)
    }
    return d
}

fun longestSubstringWithKUniqueChars(s : String, K : Int) : Int {
    var count = CharArray(26)
    s.forEach {
        count[it - 'a']++
    }

    s.forEachIndexed { index, c ->
        if (count[c - 'a'].toInt() < K)
            return Math.max(longestSubstringWithKUniqueChars(s.substring(0, index), K),
                    longestSubstringWithKUniqueChars(s.substring(index + 1), K))
    }
    return s.length
}

fun main() {
    println(longestSubstringMinKChars("ababbc", 2))
}