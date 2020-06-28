package tech.hanfeng.algorithms.dfs

import java.util.*


class SimilarStringGroups {

    fun numSimilarGroups(A: Array<String?>): Int {
        var res = 0
        for (i in A.indices) {
            if (A[i] == null) continue
            dfs(A, i)
            res++
        }
        return res
    }

    private fun dfs(A: Array<String?>, j: Int) {
        val str = A[j]
        A[j] = null
        for (i in A.indices) {
            if (A[i] == null) continue
            if (similar(str!!, A[i]!!)) dfs(A, i)
        }
    }

    private fun similar(a: String, b: String): Boolean {
        if (a.length != b.length) return false
        var cnt = 0
        for (i in a.indices) {
            if (a[i] != b[i]) cnt++
            if (cnt > 2) return false
        }

        return cnt == 0 || cnt == 2
    }

    fun numSimilarGroupsBFS(A: Array<String?>?): Int {
        if (A == null || A.isEmpty()) return 0
        val n = A.size
        var res = 0
        val visited = BooleanArray(n)
        for (i in 0 until n) {
            if (visited[i]) continue
            val q = LinkedList<Int>()
            q.offer(i)
            visited[i] = true
            while (!q.isEmpty()) {
                val curr = q.poll()
                for (j in 0 until n) {
                    if (visited[j]) continue
                    if (similar(A[curr]!!, A[j]!!)) {
                        visited[j] = true
                        q.offer(j)
                    }
                }
            }
            res++
        }
        return res
    }

    fun numSimilarGroupsUnion(A: Array<String?>?): Int {
        val parent = Array(A!!.size) { i -> i }

        fun findParent(i : Int) : Int {
            if (parent[i] != i) parent[i] = findParent(parent[i])
            return parent[i]
        }

        var n = A.size
        for (i in A.indices) {
            for(j in i + 1 until A.size) {
                val p1 = findParent(i)
                val p2 = findParent(j)
                if (p1 != p2 && similar(A[i]!!, A[j]!!)) {
                    n--
                    parent[p2] = p1
                }
            }
        }
        return n
    }
}

fun main() {
    println(SimilarStringGroups().numSimilarGroups(arrayOf("tars","rats","arts","star")))
    println(SimilarStringGroups().numSimilarGroupsBFS(arrayOf("tars","rats","arts","star")))
 //   println(SimilarStringGroups().numSimilarGroupsUnion(arrayOf("tars","rats","arts","star")))
    println(SimilarStringGroups().numSimilarGroupsUnion(arrayOf("tars","rats","satr","star")))
}