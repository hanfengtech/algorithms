package tech.hanfeng.algorithms.array

fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val index = IntArray(26)
    order.forEachIndexed { i, c ->  index[c - 'a'] = i}
    search@ for (i in 0 until words.size - 1) {
        val word1 = words[i]
        val word2 = words[i + 1]
        var minLen = Math.min(word1.length, word2.length)
        var j = 0
        while (j < minLen) {
            if (word1[j] != word2[j]) {
                if (index[word1[j] - 'a'] > index[word2[j] - 'a'])
                    return false
                continue@search
            }
            j++
        }
        if (word1.length > word2.length)
            return false
    }
    return true
}

fun main() {
    println(isAlienSorted(arrayOf("hello","leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
    println(isAlienSorted(arrayOf("word","world","row"), "worldabcefghijkmnpqstuvxyz"))
}