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

fun main() {
    val tree = populateTree()

    val it = BTIterator(tree)
    while (it.hasNext()) {
        print(" ${it.next()} ")
    }
}