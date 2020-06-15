package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateSymmectricTree
import java.util.*

fun isCompleteTree(root: TreeNode?): Boolean {
        if (root == null) return false

        val q = LinkedList<TreeNode?>()
        q.offer(root)
        var seenNull = false
        while (q.isNotEmpty()) {
            val curr = q.poll()
            if (curr == null) {
                if (!seenNull) seenNull = true
                continue
            } else if (seenNull) {
                return false
            }

            q.offer(curr.left)
            q.offer(curr.right)
        }
        return true
}

var max = 0
var counter = 0
fun isCompleteTree2(root: TreeNode?): Boolean {
    dfs(root, 0)
    return max + 1 == counter
}

fun dfs(root: TreeNode?, index: Int) {
    if (root == null) return
    max = Math.max(max, index)
    counter++
    dfs(root.left, index * 2 + 1)
    dfs(root.right, index * 2 + 2)
}

fun main() {
    println(isCompleteTree(populateSymmectricTree()))
}