package tech.hanfeng.algorithms.memorization

import java.util.*

class WordBreakII {

    private val CACHE =  mutableMapOf<String, ArrayList<String?>>()

    fun wordBreak(s: String?, wordDict: List<String>): List<String?> {
        val list = dfs(s, wordDict)
        return if (list.size == 1 && list[0] == null) {
            ArrayList()
        } else list
    }

    private fun dfs(s: String?, wordDict: List<String>): List<String?> {
        if (s == null || s.isEmpty() || wordDict.isEmpty()) {
            return ArrayList()
        }
        if (CACHE.containsKey(s)) {
            return CACHE[s]!!
        }
        val result: MutableList<String?> = ArrayList()
        wordDict.forEach { word ->
            if (s.startsWith(word)) {
                val temp = "$word "
                val tempResult = dfs(s.substring(word.length), wordDict)
                if (tempResult.isEmpty()) {
                    result.add(temp.trim())
                } else {
                    for (str in tempResult) {
                        if (str != null) {
                            val newTemp = temp + str
                            result.add(newTemp)
                        }
                    }
                }
            }
        }

        if (result.size == 0) {
            result.add(null)
        }
        CACHE[s] = ArrayList(result)
        return result
    }




    val map = mutableMapOf<Int, MutableList<String>?>()
    fun wordBreak2(s: String, wordDict: List<String>): List<String> {
        return backtrack(s, 0, wordDict.toSet(), wordDict.maxBy { it.length }?.length ?: 0)
    }

    private fun backtrack(src: String, startIndex: Int, dict: Set<String>, max: Int): List<String> {
        if (map[startIndex] != null) return map[startIndex]!!
        val result = mutableListOf<String>()
        map[startIndex] = result
        if (src.length == startIndex) return result.let { it.add("") ; it }
        var i = startIndex - 1
        while (++i < src.length && i - startIndex + 1 <= max) {
            val subStr = src.substring(startIndex, i + 1)
            if (subStr !in dict) continue
            val tails = backtrack(src, i + 1, dict, max)
            tails.forEach { result += subStr + if (it == "") it else " $it" }
        }
        return result
    }
}

fun main() {
    var res = WordBreakII().wordBreak2("catsanddog", listOf("cat", "cats", "and", "sand", "dog"))
    res?.forEach {
        println(it)
    }

    res = WordBreakII().wordBreak2("catsanddog", listOf("cat", "cats", "and", "sand", "do"))
    res?.forEach {
        println(it)
    }
}