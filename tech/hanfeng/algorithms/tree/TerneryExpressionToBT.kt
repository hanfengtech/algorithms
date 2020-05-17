package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*


fun convertExpression(expression : String) : TreeNode? {

    fun helper(i : Int) : TreeNode? {
        if (i >= expression.length) return null

        val root = TreeNode(expression[i].toInt())

        var j = i + 1

        if (j < expression.length && expression[j] == '?') {
            root.left = helper(j + 1)
        } else if (j < expression.length && expression[j] == ':'){
            root.right = helper(j + 1)
        }

        return root
    }

    return helper(0)
}

fun ternaryToTree(exp: String): TreeNode? {
    val stack = LinkedList<TreeNode>()
    var i = exp.length - 1
    while (i >= 0) {
        if (exp[i] == ':') {
            i--
            continue
        }
        if (exp[i] == '?') {
            val node = TreeNode(exp[--i].toInt())
            if (stack.isNotEmpty()) {
                node.left = stack.pop()
            }

            if (stack.isNotEmpty()) {
                node.right = stack.pop()
            }
            stack.push(node)
        } else {
            stack.push(TreeNode(exp[i].toInt()))
        }
        i--
    }
    return if (stack.isEmpty()) null else stack.pop()
}

fun main() {
    preorderPretty(ternaryToTree( "a?b?c?d:e"))
}
