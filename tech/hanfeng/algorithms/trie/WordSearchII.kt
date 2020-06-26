package tech.hanfeng.algorithms.trie

class WordSearchII {
    class TrieNode {
        var children = Array<TrieNode?>(26) { null }
        var word : String? = null
    }

    fun findWords(board: Array<CharArray>, words : Array<String>): List<String> {
        val trie = build(words)  // build trie

        val resultList = ArrayList<String>()

        for (y in board.indices) {
            for (x in board[0].indices) {
                backtracking(board, y, x, trie, resultList)  // backtracking
            }
        }

        return resultList
    }

    private fun backtracking(board: Array<CharArray>, y : Int, x : Int, node : TrieNode?, resultList : ArrayList<String>) {
        if (node == null || board[y][x] == '$')
            return

        val ch = board[y][x]

        val cur = node.children[ch - 'a'] ?: return

        if (cur.word != null) {
            resultList.add(cur.word!!)
            cur.word = null
        }

        board[y][x] = '$'
        if(y > 0) backtracking(board, y - 1, x, cur, resultList)
        if (y < board.size - 1) backtracking(board, y + 1, x, cur, resultList)
        if (x > 0) backtracking(board, y, x - 1, cur, resultList)
        if (x < board[0].size - 1) backtracking(board, y, x + 1, cur, resultList)
        board[y][x] = ch
    }

    private fun build(words : Array<String>) : TrieNode {
        var root  = TrieNode()
        for (word in words) {
            var cur = root
            for (ch in word) {
                val i = ch - 'a'
                if (cur.children[i] == null) {
                    cur.children[i] = TrieNode()
                }
                cur = cur.children[i]!!
            }
            cur.word = word
        }
        return root
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


