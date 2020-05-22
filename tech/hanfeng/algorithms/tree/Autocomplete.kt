package tech.hanfeng.algorithms.tree

class TrieNode {
    var children = Array<TrieNode?>(26) {null}
    var isWord = false
}

fun autoComplete(dict : Array<String>, prefix : String) : List<String>? {
    var trie = TrieNode()

    fun build() {
        dict.forEach {
            var cur = trie
            for (c in it) {
                val index = c - 'a'
                if (cur.children[index] == null) {
                    cur.children[index] = TrieNode()
                }
                cur = cur.children[index]!!
            }
            cur.isWord = true
        }
    }
    build()
    return search(trie, prefix)
}

fun search(trie : TrieNode, prefix : String) : List<String> {
    var resultList = ArrayList<String>()
    var cur = trie
    for (c in prefix) {
        val index = c - 'a'
        if (cur.children[index] == null) {
            return resultList
        }
        cur = cur.children[index]!!
    }
    fun helper(node : TrieNode?, result : StringBuilder) {
        if (node!!.isWord) {
            resultList.add(result.toString())
        }

        for (i in node.children.indices) {
            if (node.children[i] != null) {
                helper(node.children[i], result.append('a' + i))

                println(result.toString())
                result.deleteCharAt(result.lastIndex)
            }
        }
    }
    val result = StringBuilder(prefix)
    helper(cur,  result)
    return resultList
}
fun main() {
    val result = autoComplete(arrayOf("dog", "dark", "cat", "door", "dodge"), "do")
    result?.forEach {
        println(it)
    }
}