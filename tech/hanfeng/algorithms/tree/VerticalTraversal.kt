package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Solution {
    private val columnTable = HashMap<Int, ArrayList<Pair<Int, Int>>>()
    private var minCol = 0
    private var maxCol = 0

    private fun DFS(node : TreeNode?, row : Int, col : Int) {
        if (node == null) return

        columnTable.getOrPut(col, {ArrayList()}).add(Pair(row, node.value))
        minCol = Math.min(minCol, col)
        maxCol = Math.max(maxCol, col)

        DFS(node.left, row + 1, col - 1)
        DFS(node.right, row + 1, col + 1)
    }

    fun verticalTraversal(root : TreeNode?) : List<List<Int>> {
        val output = ArrayList<ArrayList<Int>>()
        if (root == null) return output

        DFS(root, 0, 0)  // form the columnTable

        for (i in minCol .. maxCol) {

            var list = columnTable[i]

             columnTable[i]!!.sortWith(Comparator { p1, p2 ->
                 if (p1.first == p2.first)
                     p1.second - p2.second
                 else
                     p1.first - p2.second
             })


            val sortedColumn = ArrayList<Int>()
            columnTable[i]!!.forEach {
                sortedColumn.add(it.second)
            }
            output.add(sortedColumn)
        }
        return output
    }
}

private val columnTable = HashMap<Int, ArrayList<Pair<Int, Int>>>()
private var offset = 0


fun dfs1(node : TreeNode?, row : Int, col : Int) {
    if (node == null) return
    offset = Math.min(offset, col)
    columnTable.getOrPut(col, {ArrayList()}).add(Pair(row, node.value))
    dfs1(node.left, row + 1, col - 1)
    dfs1(node.right, row + 1, col + 1)
}


// Most optimal
fun verticalTraversal1(root : TreeNode?) : List<List<Int>> {
    if (root == null) return ArrayList<ArrayList<Int>>()
    dfs1(root, 0, 0)
    var res = Array<List<Int>>(columnTable.size){listOf()}

    for (entry in columnTable.entries) {
        res[entry.key-offset] = entry.value.sortedWith(compareBy({ it.first }, { it.second })).map{it.second}.toList()
    }
    return res.toList()
}


val map = TreeMap<Int, ArrayList<Pair<Int, Int>>>()

private fun dfs2(root: TreeNode?, col: Int, row: Int) {
    if (root == null) return
    map.getOrPut(col, { arrayListOf()} ).add(Pair(row, root.value))
    dfs2(root.left, col - 1, row + 1)
    dfs2(root.right, col + 1, row + 1)
}

fun verticalTraversal(root: TreeNode?): List<List<Int>> {
    dfs2(root, 0, 0)
    val ans = arrayListOf<List<Int>>()
    map.forEach { (_, v) ->
        v.sortWith(
                compareBy({ it.first }, { it.second })
        )
        ans.add(v.map {
            it.second
        })
    }
    return ans
}



fun main() {

    val solution = Solution()

    var t = populate123Tree()
    preorderPretty(t)


    t = populate123Tree()

    val results = verticalTraversal(t)

    results.forEach {
        println(it.joinToString())
    }
}