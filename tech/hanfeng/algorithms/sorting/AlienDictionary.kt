package tech.hanfeng.algorithms.sorting

import com.sun.xml.internal.fastinfoset.util.StringArray

fun alienOrder(words : StringArray) : String {
    var dependencies = HashMap<Char, ArrayList<Char>>()
    var visited = BooleanArray(26)
    var seen = BooleanArray(26)

    for (i in 0 until words.size) {
        for (j in words[i].indices) {
            dependencies[words[i][j]] =  ArrayList()
        }
    }

    for (i in 0 until words.size - 1) {
        var word1 = words[i]
        var word2 = words[i + 1]
        if (word1.length > word2.length && word1.startsWith(word2)) {
            // Words are not sorted, thus no solution
            return ""
        }

        var i = 0
        while (i < word1.length && i < word2.length) {
            if (word1[i] != word2[i]) {
                dependencies[word2[i]]!!.add(word1[i])
                break
            }
            i++
        }
    }

    var sb = StringBuilder()


    fun dfs(c : Char) : Boolean {
        if (visited[c - 'a']) {
            return true // we already visited this node
        }

        if (seen[c - 'a']) {
            return false  // detected cycle
        }

        seen[c - 'a'] = true
        dependencies[c]!!.forEach {
            if (!dfs(it)) return false
        }

        seen[c - 'a'] = false
        visited[c - 'a'] = true
        sb.append(c)
        return true
    }

    for (c in dependencies.keys) {
        if (!dfs(c))
            return ""
    }

    return sb.toString()
}