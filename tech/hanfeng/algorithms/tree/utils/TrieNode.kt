package tech.hanfeng.algorithms.tree.utils

class TrieNode {
    var item = ""
    var children = mutableListOf<TrieNode>()
    var isWord = false

    fun printTrie(root : TrieNode, level : Int = 0) {
        for (i in root.children.indices) {
            if (root.children[i] != null) {
                print("$level  ")
                for (j in 0 until level) {
                    print(" ")
                }
                println('a' + i)
                if (root.children[i]!!.isWord) {
                    println()
                }

                printTrie(root.children[i]!!, level + 1)

            }
        }
    }
}