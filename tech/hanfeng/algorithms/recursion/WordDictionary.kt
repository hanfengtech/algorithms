package tech.hanfeng.algorithms.recursion

class WordDictionary {
    class TrieNode {
        var isWord = false
        var children = Array<TrieNode?>(26) { null }
    }

    var root = TrieNode()

    fun addWord(word :String) {
        var cur = root
        for (c in word.toCharArray()) {
            val index = c - 'a'
            if (cur.children[index] == null) {
                cur.children[index] = TrieNode()
            }

            cur = cur.children[index]!!
        }
        cur.isWord = true
    }

    fun search(word : String) : Boolean {
        return match(word.toCharArray(), 0, root)
    }

    private fun match(chs: CharArray, k: Int, node: TrieNode): Boolean {
        if (k == chs.size) {
            return node.isWord
        }

        if (chs[k] != '.') {
            val index = chs[k] - 'a'
            return node.children[index] != null
                    && match(chs, k + 1, node.children[index]!!)
        } else {
            for (i in node.children.indices) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i]!!)) {
                        return true
                    }
                }
            }
        }
        return false
    }
}

fun main() {
    val wd = WordDictionary()
    wd.addWord("bad")
    wd.addWord("dad")
    wd.addWord("mad")
    println(wd.search("pad"))
    println(wd.search("bad"))
    println(wd.search(".ad"))
    println(wd.search("b.."))
    println(wd.search("hello"))
}