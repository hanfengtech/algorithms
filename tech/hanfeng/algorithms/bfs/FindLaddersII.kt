package tech.hanfeng.algorithms.bfs

import java.util.*
import kotlin.collections.ArrayList

fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    val set = wordList.toMutableSet()
    val resultList = ArrayList<ArrayList<String>>()
    val queue = LinkedList<MutableList<String>>()
    queue.add(mutableListOf(beginWord))
    var level = 1
    var finalLevel = Int.MAX_VALUE
    val usedWords= ArrayList<String>()

    processqueue@ while (queue.isNotEmpty()) {
        val list = queue.poll()
        if (list.size > level) {     // meaning: new word was added to list
            set.removeAll(usedWords)
            usedWords.clear()
            level = list.size
            if (level > finalLevel) break
        }
        val strArr = list[list.lastIndex].toCharArray()    // get the last word in the list and turn it into char array for modification
        for (i in strArr.indices) {
            val originalCh = strArr[i]
            for (ch in 'a' .. 'z') {                // replacing char with a .. z
                if (ch == originalCh) {
                    continue
                }
                strArr[i] = ch
                val newStr = String(strArr)
                if (set.contains(newStr)) {         // check if the new string in the word set
                    usedWords.add(newStr)           // add the new match word into usedWord to mark it as used word
                    val newList = ArrayList(list)   // creating a new list
                    newList.add(newStr)             // add the new string to the new list
                    if (newStr == endWord) {        // reached the end word
                        resultList.add(newList)     // store the new list into result list
                        finalLevel = level
                        continue@processqueue       // continue process the queue
                    } else {
                        queue.add(newList)          // add the new list to the queue so that we can process the next level of the final ladder
                    }
                }
            }
            strArr[i] = originalCh                  // restore the character back to form the original word
        }
    }
    return resultList
}

fun main() {
    var res = findLadders("hit", "cog", listOf("hot","dot","dog","lot","log","cog"))

    res.forEach {
        println(it.joinToString())
    }
}