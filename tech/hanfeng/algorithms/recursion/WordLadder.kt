package tech.hanfeng.algorithms.recursion

import java.util.*

fun ladderLength(beginWord : String, endWord : String, wordList : List<String>) : Int {
    var reached = HashSet<String>()
    reached.add(beginWord)
    var distance = 1
    var wordSet = wordList.toHashSet()

    while (!reached.contains(endWord)) {
        var levelSet = HashSet<String>()

        for (each in reached) {
            val chars = each.toCharArray()
            for (i in each.indices) {
                for (ch in 'a'..'z') {            // replace the character with a to z
                    val tmp = chars[i]
                    chars[i] = ch
                    val word = String(chars)
                    if (wordSet.contains(word)) {
                        if (word == endWord)      // reached the end word
                            return distance + 1
                        levelSet.add(word)
                        wordSet.remove(word)
                    }
                    chars[i] = tmp
                }
            }
        }

        distance++

        if (levelSet.size == 0) {
            return 0
        }

        reached = levelSet
    }
    return distance
}


fun main() {
    println(ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))
    println(ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog", "zit", "cot")))
}