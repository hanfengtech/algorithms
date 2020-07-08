package tech.hanfeng.algorithms.trie

class StreamChecker(words: Array<String>) {

    private var words : Array<String> = words

    class TrieNode {
        var isWord = false
        var children = Array<TrieNode?>(26) { null }
    }

    private var trie = TrieNode()
    var curr = TrieNode()
    var sb = StringBuilder()

    init {
        for (word in words) {
            curr = trie
            for (i in word.lastIndex downTo 0) {
                val index = word[i] - 'a'
                if ( curr.children[index] == null) {
                    curr.children[index] = TrieNode()
                }
                curr = curr.children[index]!!
            }
            curr.isWord = true
        }
        curr = trie
    }

    fun query(letter: Char): Boolean {
        sb.append(letter)
        var node: TrieNode = trie
        for (i in sb.lastIndex downTo 0) {
            val next = node.children[sb[i] - 'a'] ?: return false
            if (next.isWord) return true
            node = next
        }
        return false
    }
}

fun main() {
    val streamChecker = StreamChecker(arrayOf("ab","ba","aaab","abab","baa"))
    println(streamChecker.query('a'))
    println(streamChecker.query('a'))
    println(streamChecker.query('a'))
    println(streamChecker.query('a'))
    println(streamChecker.query('a'))
    println(streamChecker.query('b'))
    println(streamChecker.query('a'))
    println(streamChecker.query('b'))
    println(streamChecker.query('a'))
}