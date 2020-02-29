package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*

fun kthSmallest(root : TreeNode?, k : Int) : Int {
    val stack = Stack<TreeNode>()
    var cur = root
    var count = 1

    while (cur != null) {
        stack.push(cur)
        cur = cur.left
    }

    while (stack.isNotEmpty()) {
        var node = stack.pop()
        if (count++ == k) return node.value

        if (node.right != null) {
            cur = node.right
            while(cur != null) {
                stack.push(cur)
                cur = cur.left
            }
        }
    }

    throw IllegalArgumentException()
}

fun main() {
    val tree = populateTree()
    preorderPretty(tree)
    println(kthSmallest(tree, 5))
    println(kthSmallest(tree, 8))
}