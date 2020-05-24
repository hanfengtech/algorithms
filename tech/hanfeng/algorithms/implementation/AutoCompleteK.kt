package tech.hanfeng.algorithms.implementation

const val SPACE_INDEX = 26
const val RESULT_COUNT = 3

class AutocompleteSystem(sentences: Array<String>, times: IntArray) {

    internal class TrieNode {
        var children = Array<TrieNode?>(27) { null }
        var isSentence = false
        var occur = 0
    }

    internal data class Sentences(var content: String, var times: Int)

    private var trie = TrieNode()
    private var input = StringBuilder()

    init {
        sentences.forEachIndexed { i, s ->
            add(s, times[i])
        }
    }

    private fun add(s: String, times: Int) {
        var cur = trie
        for (c in s) {
            val index = toInt(c)
            if (cur.children[index] == null) {
                cur.children[index] = TrieNode()
            }
            cur = cur.children[index]!!
        }
        cur.isSentence = true
        cur.occur += times
    }

    private fun toInt(c: Char): Int {
        return if (c == ' ') SPACE_INDEX else c - 'a'
    }

    private fun toChar(index: Int): Char {
        return if (index == SPACE_INDEX) ' ' else 'a' + index
    }

    private fun dfs(node: TrieNode?, list: MutableList<Sentences>, result: StringBuilder) {
        if (node!!.isSentence) {
            list.add(Sentences(result.toString(), node.occur))
        }

        for (i in node.children.indices) {
            if (node.children[i] != null) {
                val ch = toChar(i)
                dfs(node.children[i], list, result.append(ch))
                result.deleteCharAt(result.lastIndex)
            }
        }
    }

    private fun lookup(t: TrieNode, s: String): ArrayList<Sentences> {
        var cur: TrieNode? = t
        val list = ArrayList<Sentences>()
        for (i in s.indices) {
            if (cur!!.children[toInt(s[i])] == null) {
                return ArrayList()
            }
            cur = cur.children[toInt(s[i])]
        }
        dfs(cur, list, StringBuilder(s))
        return list
    }

    fun input(c: Char): List<String> {
        val resultList = ArrayList<String>()

        return if (c == '#') {
            add(input.toString(), 1)
            input.clear()
            ArrayList()
        } else {
            input.append(c)
            val list = lookup(trie, input.toString())
            list.sortWith(Comparator { a, b -> if (a.times == b.times) a.content.compareTo(b.content) else b.times - a.times })
            for (i in 0 until RESULT_COUNT.coerceAtMost(list.size)) {
                resultList.add(list[i].content)
            }
            resultList
        }
    }
}

fun main() {
    val autocomplete = AutocompleteSystem(arrayOf("i love you", "isl" +
            "and", "ironman", "i love leetcode"), intArrayOf(5, 3, 2, 2))
    autocomplete.input('i').forEach { println(it) }
    println()
    autocomplete.input(' ').forEach { println(it) }
    println()
    autocomplete.input('a').forEach { println(it) }
    println()
    autocomplete.input('#').forEach { println(it) }
    println()
    autocomplete.input('i').forEach { println(it) }
    println()
    autocomplete.input(' ').forEach { println(it) }
    println()
    autocomplete.input('a').forEach { println(it) }
    println()
    autocomplete.input('#').forEach { println(it) }
    println()
    autocomplete.input('i').forEach { println(it) }
    println()
    autocomplete.input(' ').forEach { println(it) }
    println()
    autocomplete.input('a').forEach { println(it) }
    println()
    autocomplete.input('#').forEach { println(it) }
}
