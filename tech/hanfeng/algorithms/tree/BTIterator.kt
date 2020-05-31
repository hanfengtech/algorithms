package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import java.util.*

class BTIterator(root: TreeNode?) {
    var stack = Stack<TreeNode>()

    init {
        var cur = root
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }

    fun hasNext() : Boolean {
        return stack.isNotEmpty()
    }

    fun next() : Int {
        if (stack.isEmpty()) throw Exception("No more data!")
        val node = stack.pop()
        var cur = node

        if (cur.right != null) {
            cur = cur.right
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
        }

        return node.value
    }
}

class BSTIterator2(var root : TreeNode?) {

    private var stack = LinkedList<TreeNode>()

    init {
        var cur = root
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }

    fun next() : Int {
        if (stack.isEmpty()) throw Exception("No more data")
        val node = stack.pop()
        var cur = node
        if (cur.right != null) {
            cur = cur.right
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
        }
        return node.value
    }

    fun hasNext() : Boolean {
        return stack.isNotEmpty()
    }
}


fun main() {
    val tree = populateTree()

    val it = BTIterator(tree)
    while (it.hasNext()) {
        print(" ${it.next()} ")
    }

    println()

    val t = BTIterator(null)
    println(t.next())
}