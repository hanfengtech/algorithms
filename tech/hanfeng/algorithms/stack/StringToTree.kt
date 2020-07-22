package tech.hanfeng.algorithms.stack

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*

fun str2tree(s: String): TreeNode? {
    if (s.isEmpty()) return null
    val stack = LinkedList<TreeNode>()
    var root : TreeNode? = null
    var i = 0
    val n = s.length
    while(i < n) {
        when (val c = s[i]) {
            in '0' .. '9', '-' -> {
                var value = c.toString()
                while(i + 1 < n && s[i+1] in '0' .. '9') {
                    value += s[i+1]
                    i++
                }
                val node = TreeNode(value.toInt())
                if (root != null) {
                    if (root.left == null) {
                        root.left = node
                    } else {
                        root.right = node
                    }
                }
                stack.push(node)
            }
            '(' -> root = stack.peek()
            else -> stack.pop()
        }
        i++
    }
    return stack.pop()
}

fun main() {
    val tree = str2tree("4(2(3)(1))(6(5))")
    preorderPretty(tree)
}