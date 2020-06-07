package tech.hanfeng.algorithms.graph

import java.util.*
import kotlin.collections.HashMap

class Solution {

    private var map = HashMap<Int, LinkedList<Int>>()
    private var visited : IntArray? = null

    fun countComponents(n : Int, edges: Array<IntArray>) : Int {
         edges.forEach{
             map.getOrPut(it[0]){LinkedList()}.add(it[1])   // undirected graph add two
             map.getOrPut(it[1]){LinkedList()}.add(it[0])
         }


        var count = 0

        visited = IntArray(n)
        for( i in 0 until n) {
            if (visited!![i] == 0) {  // not visited yet
                dfs(i)
                count++
            }
        }

        return count
    }

    private fun dfs(node : Int) {
        if (visited!![node] != 0) {  // visited
            return
        }

        visited!![node] = 1  // mark as visited

        if (map.containsKey(node)) {
            val neighbors = map[node]
            while(neighbors!!.isNotEmpty()) {
                val n = neighbors.poll()
                dfs(n)
            }
            map.remove(node)
        }
    }


    fun countComponentsUnion(n : Int, edges: Array<IntArray>) : Int {
        var parent = IntArray(n) { i -> i }

        fun find(x : Int) : Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        var count = n

        edges.forEach {
            val x = find(it[0])
            val y = find(it[1])
            if (x != y) {
                parent[x] = y
                count--
            }
        }

        return count
    }

}

fun main() {
    println(Solution().countComponentsUnion(5, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(0,2), intArrayOf(3,4))))

    println(Solution().countComponentsUnion(4, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2))))

    println(Solution().countComponentsUnion(5, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(3,4))))

    println(Solution().countComponentsUnion(5, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(3,4))))

}