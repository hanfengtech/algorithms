package tech.hanfeng.algorithms.array
fun findAllConcatenatedWords(words: Array<String>) : List<String> {
    val wordDict = words.toSet()
    val cache = HashMap<String, Boolean>()
    val resultList = ArrayList<String>()
    for (word in words) {
        if (canForm(word, wordDict, cache)) {
            resultList.add(word)
        }
    }
    return resultList
}

fun canForm(word: String, wordDict: Set<String>, cache : HashMap<String, Boolean>) : Boolean {
    if (cache.contains(word))
        return cache[word]!!
    for (index in 1 until word.length) {
        val prefix = word.substring(0, index)
        val suffix = word.substring(index)
        if (wordDict.contains(prefix)) {
            if (wordDict.contains(suffix) or canForm(suffix, wordDict, cache)) {
                cache[word] = true
                return true
            }
        }
    }
    cache[word] = false
    return false
}

fun main() {
    val list = findAllConcatenatedWords(arrayOf("cat", "cats", "dog", "catsdog", "catcat"))
    list.forEach {
        println(it)
    }
}