package tech.hanfeng.algorithms.trie

class WordSearchII {
    class TrieNode {
        var isWord = false
        var children = Array<TrieNode?>(26) { null }
        var isFound = false
    }

    fun findWords(board: Array<CharArray>, words : Array<String>): List<String> {
        // build trie
        val trie = TrieNode()
        build(trie, words)

        val resultList = ArrayList<String>()
        val builder = StringBuilder()

        for (y in board.indices) {
            for (x in board[0].indices) {
                builder.clear()
                backtracking(board, y, x, trie, resultList, builder)
            }
        }

        return resultList
    }

    private fun backtracking(board: Array<CharArray>, y : Int, x : Int, node : TrieNode?, resultList : ArrayList<String>, builder : StringBuilder) {
        if (node == null || y < 0 || y >= board.size || x < 0 || x >= board[0].size || board[y][x] == '$')
            return
        val ch = board[y][x]

        val cur = node.children[ch - 'a'] ?: return

        builder.append(ch)

        if (cur.isWord && !cur.isFound) {
            resultList.add(builder.toString())
            cur.isFound = true
        }

        board[y][x] = '$'
        backtracking(board, y - 1, x, cur, resultList, builder)
        backtracking(board, y + 1, x, cur, resultList, builder)
        backtracking(board, y, x - 1, cur, resultList, builder)
        backtracking(board, y, x + 1, cur, resultList, builder)
        builder.deleteCharAt(builder.lastIndex)
        board[y][x] = ch
    }

    private fun build(trie: TrieNode, words : Array<String>) {
        words.forEach { word ->
            var cur = trie
            for (ch in word) {
                val index = ch - 'a'
                if (cur.children[index] == null) {
                    cur.children[index] = TrieNode()
                }
                cur = cur.children[index]!!
            }
            cur.isWord = true
        }
    }
}

fun main() {
    var board = arrayOf(charArrayOf(
            'o','a','a','n'), charArrayOf(
            'e','t','a','e'), charArrayOf(
            'a','t','s','r'), charArrayOf(
            'i','f','l','v'))

    var words = arrayOf("oath","pea","eat","eats")

    println(WordSearchII().findWords(board, words).joinToString())


    board = arrayOf(charArrayOf(
            'a','a'))

    words = arrayOf("a")

    println(WordSearchII().findWords(board, words).joinToString())
}


